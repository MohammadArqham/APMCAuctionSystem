package com.terminalx.auctionservice.repository;

import com.terminalx.auctionservice.model.auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface auctionRepository extends MongoRepository<auction,String> {
}
