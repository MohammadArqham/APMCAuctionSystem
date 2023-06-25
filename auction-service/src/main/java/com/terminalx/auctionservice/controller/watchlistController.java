package com.terminalx.auctionservice.controller;

import com.terminalx.auctionservice.dto.watchlistResponce;
import com.terminalx.auctionservice.model.watchlist;
import com.terminalx.auctionservice.service.auctionService;
import com.terminalx.auctionservice.service.watchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/watchlist")
@RestController
public class watchlistController {
    @Autowired
    watchlistService service;

    @Autowired
    auctionService auctionservice;
    @PostMapping("")
    public String addOne(@RequestBody watchlist data){
        return service.addOne(data);
    }

    @GetMapping("")
    public List<watchlist> getAll(){
        return  service.getAll();
    }

    @GetMapping("/getByUserId/{id}")
    public List<watchlistResponce> getByUserId(@PathVariable String id){
        List<watchlist> list = service.getByUserId(id);
        System.out.println(list.toString());
        List<watchlistResponce> responce = new ArrayList<>();
        list.forEach(item->{
            responce.add(new watchlistResponce(item.getId(), auctionservice.getById(item.getAuctionId())));
        });
        return responce;
    }

    @DeleteMapping("/{userId}/{auctionId}")
    public Boolean deleteByUserIdAndAuctionId(@PathVariable String userId,@PathVariable String auctionId){
        return service.deleteByUserIdAndAuctionId(userId,auctionId);
    }

    @DeleteMapping("/deleteById/{id}")
    public  boolean deleteById(@PathVariable String id){
        System.out.println("dlelting item-->"+id);
        return  service.deleteById(id);
    }

}
