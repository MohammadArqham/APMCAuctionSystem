package com.terminalx.auctionservice.service;

import com.terminalx.auctionservice.dto.auctionResponce;
import com.terminalx.auctionservice.dto.bidHistoryResponce;
import com.terminalx.auctionservice.dto.bidResponce;
import com.terminalx.auctionservice.model.bid;
import com.terminalx.auctionservice.model.user;
import com.terminalx.auctionservice.repository.bidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class bidService {

    @Autowired
    private bidRepository bidRepo;
    @Autowired
    private apiService apiservice;





    public String addOne(bid item) {
        item.setCreationDate(LocalDateTime.now());
        bid b = bidRepo.save(item);
        return  b.getId();
    }

    public List<bid> getAll() {
        return bidRepo.findAll();
    }

    public bidResponce getById(String id){

        bid b = bidRepo.findById(id).get();
        user u = apiservice.getUserById(b.getBidderId());
        return new bidResponce(u.getId(),u,b.getAuctionId(),b.getAmount(),b.getCreationDate());
    }

    public List<bidResponce> getByAuctionId(String id) {

        List<bid> list = bidRepo.findByAuctionId(id);

        Collections.sort(list, new Comparator<bid>() {
            @Override
            public int compare(bid o1, bid o2) {
                return (int) (o2.getAmount() - o1.getAmount());
            }
        });
        List<bidResponce> responce = new ArrayList<>();

        list.forEach(item -> responce.add(this.getById(item.getId())));

        return responce;

    }


}
