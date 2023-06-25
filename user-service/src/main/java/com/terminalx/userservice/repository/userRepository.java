package com.terminalx.userservice.repository;

import com.terminalx.userservice.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends MongoRepository<user,String> {

    Optional<user> findByUsername(String username);

    Optional<user> findByEmail(String username);
}
