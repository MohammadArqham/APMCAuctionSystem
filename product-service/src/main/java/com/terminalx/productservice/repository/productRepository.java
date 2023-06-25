package com.terminalx.productservice.repository;

import com.terminalx.productservice.model.Category;
import com.terminalx.productservice.model.Product;
import com.terminalx.productservice.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends MongoRepository<Product,String> {


    List<Product> findByProducer(user u);

    List<Product> findByCategory(Category category);
}
