package com.terminalx.auctionservice.controller;

import com.terminalx.auctionservice.dto.auctionResponce;
import com.terminalx.auctionservice.model.auction;
import com.terminalx.auctionservice.service.auctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auction")
@RestController
public class auctionController {
    @Autowired
    private auctionService service;

    @PostMapping("/addOne")
    public String addOne(@RequestBody auction item){
        return service.addOne(item);
    }

    @GetMapping("/getAll")
    public List<auction> getAll(){
        return service.getAll();
    }


    @PostMapping("/addOneForm")
    public String addOneForm(
            @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime
    ){
        System.out.println("--->"+startTime+"\n"+endTime);
        return "added..!";
    }

    @GetMapping("/getById/{id}")
    public auctionResponce getById(@PathVariable String id){
        return service.getById(id);
    }

    @GetMapping("/getAllAuctions")
    public List<auctionResponce> getAllAuctions(){
       return service.getAllAuctions();
    }

    @GetMapping("/getByUserId/{id}")
    public List<auctionResponce> getByUserId(@PathVariable String id){
        return service. getByUserId(id);
    }

    @Scheduled(fixedRate = 1000)
    public void checkAuctionStatus(){
        service.checkAuctionStatus();
    }

}
