package com.terminalx.userservice.service;

import com.terminalx.userservice.model.fileData;
import com.terminalx.userservice.repository.fileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
    private fileRepository fileDataRepo;



    public fileData fileUpload(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence "+ fileName);
            }
            fileData fd = new fileData(
                    file.getName(),
                    file.getContentType(),
                    null,
                    file.getBytes()
            );
            return fileDataRepo.save(fd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public fileData fileDowload(String fileId) throws Exception {
        return fileDataRepo
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }


}