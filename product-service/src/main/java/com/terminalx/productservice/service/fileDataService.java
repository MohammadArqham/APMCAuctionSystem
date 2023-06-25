package com.terminalx.productservice.service;

import com.terminalx.productservice.model.fileData;
import com.terminalx.productservice.repository.fileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class fileDataService {
    @Autowired
    fileDataRepository fileDataRepo;
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
