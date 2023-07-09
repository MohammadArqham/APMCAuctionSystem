package com.terminalx.productservice.controller;

import com.terminalx.productservice.dto.productRequest;
import com.terminalx.productservice.model.Category;
import com.terminalx.productservice.model.Product;
import com.terminalx.productservice.model.fileData;
import com.terminalx.productservice.model.user;
import com.terminalx.productservice.service.apiService;
import com.terminalx.productservice.service.fileDataService;
import com.terminalx.productservice.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/product")
@RestController
public class productController {
    @Autowired
    productService service;

    @Autowired
    fileDataService fileService;
    @Autowired
    apiService apiservice;
    @PostMapping("")
    public String addOne(@RequestBody productRequest product){

        Product p = service.addOne(product);
        return p.getId();
    }

    @GetMapping("/getById/{id}")
    public Product getOne(@PathVariable String id){
        return service.getById(id);
    }
    @GetMapping("")
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/getByUserId/{userId}")
    public List<Product> getByUserId(@PathVariable String userId){
        return service.getByUserId(userId);
    }

    @GetMapping("/getByCategory/{cat}")
    public List<Product> getByCategory(@PathVariable String cat){
        return service.getByCategory(cat);

    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file)  throws Exception{

        fileData fd = fileService.fileUpload(file);

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/product/download/")
                .path(fd.getId()).toUriString();

    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        fileData attachment = null;
        attachment = fileService.fileDowload(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }


    @PostMapping("/addOneForm")
    public String  addOneProductForm(
            @RequestParam("name") String name,
            @RequestParam("discription") String discription,
            @RequestParam("reservePrice") int reservePrice,
            @RequestParam("quantity") float quantity,
            @RequestParam("category") String category,
            @RequestParam("producer") String producer,
            @RequestParam("productImage") MultipartFile productimage
    ){
        productRequest p = new productRequest(
                name,
                discription,
                reservePrice,
                quantity,
                category,
                producer,
                LocalDate.now(),
                null
        );

        fileData fd = fileService.fileUpload(productimage);
        p.setProductImage(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/product/download/")
                .path(fd.getId()).toUriString());
//localhost:8084/product/download/1213
        service.addOne(p);
        return "product added..!";
    }

}
