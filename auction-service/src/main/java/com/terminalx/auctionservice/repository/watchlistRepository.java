package com.terminalx.auctionservice.repository;

import com.terminalx.auctionservice.model.watchlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface watchlistRepository extends MongoRepository<watchlist,String> {
    List<watchlist> findByUserId(String id);


    Optional<watchlist> findByUserIdAndAuctionId(String userId, String auctionId);

    Optional<watchlist> deleteByUserIdAndAuctionId(String userId, String auctionId);
}
