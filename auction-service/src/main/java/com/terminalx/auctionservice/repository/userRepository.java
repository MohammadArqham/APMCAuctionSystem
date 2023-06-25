package com.terminalx.auctionservice.repository;

import com.terminalx.auctionservice.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<user,String> {
}
