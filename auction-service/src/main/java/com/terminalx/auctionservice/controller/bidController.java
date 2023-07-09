package com.terminalx.auctionservice.controller;

import com.terminalx.auctionservice.dto.auctionResponce;
import com.terminalx.auctionservice.dto.bidHistoryResponce;
import com.terminalx.auctionservice.dto.bidResponce;
import com.terminalx.auctionservice.model.bid;
import com.terminalx.auctionservice.repository.bidRepository;
import com.terminalx.auctionservice.service.auctionService;
import com.terminalx.auctionservice.service.bidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/bid")
@RestController
@CrossOrigin("*")
public class bidController {
    @Autowired
    private bidService service;

    @Autowired
    private bidRepository bidRepo;
    @Autowired
    private auctionService auctionservice;

    @PostMapping("/addOne")
    public String addOne(@RequestBody bid item){
        return service.addOne(item);
    }

    @GetMapping("/getByid/{id}")
    public bidResponce getById(@PathVariable String id){
        return service.getById(id);
    }


    @GetMapping("/getAll")
    public List<bid> getAll(){
        return service.getAll();
    }

    @GetMapping("/getByAuctionId/{id}")
    public List<bidResponce> getByAuctionId(@PathVariable String id){
        return service.getByAuctionId(id);
    }

    @GetMapping("/getByUserId/{userId}")
    public List<bidHistoryResponce> getByUserId(@PathVariable String userId){

        List<bid> b = bidRepo.findByBidderId(userId);
        List<bidHistoryResponce> responce = new ArrayList<>();
        b.forEach(item->{
            auctionResponce res = auctionservice.getById(item.getAuctionId());
            if(res!=null)
            responce.add(new bidHistoryResponce(item.getId(),res,item.getAmount(),item.getCreationDate()));
        });
        return responce;
    }




}
