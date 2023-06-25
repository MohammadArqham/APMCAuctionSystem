package com.terminalx.userservice.repository;

import com.terminalx.userservice.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<user,String> {

}
