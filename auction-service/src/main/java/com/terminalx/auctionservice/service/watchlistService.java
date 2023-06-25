package com.terminalx.auctionservice.service;

import com.terminalx.auctionservice.model.watchlist;
import com.terminalx.auctionservice.repository.watchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class watchlistService {

    @Autowired
    watchlistRepository watchlistRepo;


    public String addOne(watchlist data) {
        Optional<watchlist> w1 = watchlistRepo.findByUserIdAndAuctionId(data.getUserId(), data.getAuctionId());
        if(w1.isPresent()){
            return "data exists..!";
        }

        watchlist w = watchlistRepo.save(data);
        return w.getId();
    }

    public List<watchlist> getAll() {
        return watchlistRepo.findAll();
    }

    public List<watchlist> getByUserId(String id) {
        return watchlistRepo.findByUserId(id);
    }

    public Boolean deleteByUserIdAndAuctionId(String userId, String auctionId) {
        Optional<watchlist> w = watchlistRepo.findByUserIdAndAuctionId(userId,auctionId);
        if(w.isPresent()){
            watchlistRepo.delete(w.get());
            return  true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        if(watchlistRepo.findById(id).isPresent()){

            watchlistRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
