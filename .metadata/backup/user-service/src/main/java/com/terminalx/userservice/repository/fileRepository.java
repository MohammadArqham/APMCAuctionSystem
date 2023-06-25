package com.terminalx.userservice.repository;

import com.terminalx.userservice.model.fileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fileRepository extends MongoRepository<fileData, String> {

}