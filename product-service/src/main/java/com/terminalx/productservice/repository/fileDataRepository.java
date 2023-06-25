package com.terminalx.productservice.repository;

import com.terminalx.productservice.model.fileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fileDataRepository extends MongoRepository<fileData,String> {
}
