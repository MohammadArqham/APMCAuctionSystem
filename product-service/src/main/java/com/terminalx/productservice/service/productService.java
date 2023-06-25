package com.terminalx.productservice.service;

import com.terminalx.productservice.dto.productRequest;
import com.terminalx.productservice.model.Category;
import com.terminalx.productservice.model.Product;
import com.terminalx.productservice.model.fileData;
import com.terminalx.productservice.model.user;
import com.terminalx.productservice.repository.fileDataRepository;
import com.terminalx.productservice.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class productService {

    @Autowired
    productRepository repo;
    @Autowired
    apiService apiservice;

    @Autowired
    fileDataRepository fileDataRepo;
    public Product addOne(productRequest product) {
        user u = apiservice.getUserById(product.getProducerId());
        u.setId(product.getProducerId());

        Product product1 =
                new Product(product.getName(),
                        product.getDiscription(),
                        product.getReservePrice(),
                        product.getQuantity(),
                        Category.valueOf(product.getCategory()),
                        u,
                        LocalDate.now(),
                        product.getProductImage()
                );


        return repo.save(product1);
     }

    public List<Product> getAll() {
        return repo.findAll();
    }


    public List<Product> getByUserId(String userId) {
        user u = apiservice.getUserById(userId);
        u.setId(userId);
        System.out.println("user:--"+u.toString());
        List<Product> allItems = repo.findAll().stream()
                .filter(item -> {
                    user producer = item.getProducer();
                    return producer != null && producer.getId() != null && producer.getId().equals(userId);
                })
                .toList();


        return allItems;
    }

    public List<Product> getByCategory(String cat) {

        return repo.findByCategory(Category.valueOf(cat));
    }

    public Product getById(String id) {
        return repo.findById(id).get();
    }



}
