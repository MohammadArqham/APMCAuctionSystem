package com.terminalx.auctionservice.service;

import com.terminalx.auctionservice.dto.auctionResponce;
import com.terminalx.auctionservice.dto.bidResponce;
import com.terminalx.auctionservice.model.AuctionItem;
import com.terminalx.auctionservice.model.Product;
import com.terminalx.auctionservice.model.auction;
import com.terminalx.auctionservice.model.bid;
import com.terminalx.auctionservice.repository.auctionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class auctionService {

    private Queue<AuctionItem> auctionsList;

    private auctionRepository auctionRepo;

    @Autowired
    private bidService bidservice;

    @Autowired
    private apiService apiservice;


    @Autowired
    public auctionService(auctionRepository auctionRepository) {
        this.auctionRepo = auctionRepository;
    }

    @PostConstruct
    public void initializeAuctionsList() {
        auctionsList = new PriorityQueue<>(Comparator.comparing(AuctionItem::getEndTime));

        // Fetch data from repository and filter out closed items
        List<auction> dbAuctions = auctionRepo.findAll().stream()
                .filter(auction -> !auction.getClosed())
                .collect(Collectors.toList());

        // Extract id and endTime attributes and add them to auctionsList
        dbAuctions.forEach(auction -> {
            LocalDateTime endTime = auction.getEndTime();
            if (endTime == null) {
                endTime = LocalDateTime.now();
            }
            auctionsList.offer(new AuctionItem(auction.getId(), endTime));
        });

        // Print the contents of auctionsList
        System.out.println("Auctions List: " + auctionsList.toString());
    }



    public String addOne(auction item) {
        item.setCreationDate(LocalDateTime.now());
        auction a = auctionRepo.save(item);
        auctionsList.offer(new AuctionItem(a.getId(),a.getEndTime()));

        return a.getId();
    }

    public List<auction> getAll() {
        return auctionRepo.findAll();
    }

    public auctionResponce getById(String id) {
        auction a= auctionRepo.findById(id).get();
        Product p = apiservice.getProductById(a.getProductId());
        List<bidResponce> bidlist = bidservice.getByAuctionId(a.getId());

        return new auctionResponce(a.getId(),a.getStartTime(),a.getEndTime(),a.getClosed(),p,bidlist);
    }


    public List<auctionResponce> getAllAuctions() {
        List<auction> actionList = auctionRepo.findAll();

        List<auctionResponce> responce = new ArrayList<>();

        actionList.stream().forEach(item-> responce.add(getById(item.getId())) );
        return responce;
    }

    //logical implementation of auction service

    public void checkAuctionStatus() {
        LocalDateTime currentTime = LocalDateTime.now();

        while (!auctionsList.isEmpty() && currentTime.isAfter(auctionsList.peek().getEndTime())) {
            AuctionItem auctionItem = auctionsList.poll();
            handleAuctionEnd(auctionItem.getItemId());
        }
    }


    @Async
    protected void handleAuctionEnd(String itemId) {

        System.out.println("Auction with Item ID " + itemId + " has ended.");

        auction a = auctionRepo.findById(itemId).get();
        a.setClosed(true);
        auctionRepo.save(a);

        List<bidResponce> bidlist = bidservice.getByAuctionId(itemId);
        bidResponce winner = bidlist.isEmpty() ? null : bidlist.get(0);
        if(winner != null){
            System.out.println(winner.getBidder().getFullname() +" with email Id "+ winner.getBidder().getEmail()+" has won the bid");
            String message = "Mr " + winner.getBidder().getFullname() + ",\n"
                    + "you have won the bid with AuctionId ID: " + winner.getAuctionId() + "\n"
                    + "with ₹ " + winner.getAmount();

            String encodedString = URLEncoder.encode(message, StandardCharsets.UTF_8);

            apiservice.senMail(winner.getBidder().getEmail(),encodedString);
        }

    }

    public List<auctionResponce> getByUserId(String id) {
        List<auctionResponce> allAuctions = getAllAuctions();

        List<auctionResponce> filteredAuctions = allAuctions.stream()
                .filter(item -> item.getProduct().getProducer().getId().equals(id))
                .collect(Collectors.toList());

        return filteredAuctions;
    }

}
