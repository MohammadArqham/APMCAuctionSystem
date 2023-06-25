package com.terminalx.auctionservice.repository;

import com.terminalx.auctionservice.model.bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bidRepository extends MongoRepository<bid,String> {
    List<bid> findByAuctionId(String id);

    List<bid> findByBidderId(String userId);
}
