package com.terminalx.userservice.service;

import com.terminalx.userservice.model.fileData;
import com.terminalx.userservice.repository.fileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class fileUploadService {
    @Autowired
    private fileRepository fileRepo;



    public String uploadFile(String PATH, MultipartFile file) throws IOException {

        fileData PFile=new fileData(file.getOriginalFilename(),file.getContentType(),null);

        fileRepo.save(PFile);
        String fullPath=PATH+PFile.getId()+PFile.getName().substring(PFile.getName().lastIndexOf("."));

        System.out.println("----> "+fullPath);

        PFile.setImagePath(fullPath);
        fileRepo.save(PFile);

        Files.copy(file.getInputStream(), Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("-----------\n "+PFile.getId());
        return PFile.getId();
    }


    public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
        System.out.println("---->"+fileName);
        Optional<fileData> p = fileRepo.findById(fileName);
        System.out.println("  ->  "+p.get().getImagePath());
        byte[] filedata =  Files.readAllBytes(new File(p.get().getImagePath()).toPath());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(p.get().getType())).body(filedata);
    }

    public List<fileData> getFileData() {
        return fileRepo.findAll();
    }
}