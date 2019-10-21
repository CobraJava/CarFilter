package com.shop.electronic.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${file.upload-dir}")
    private String fileDir;

    @Override
    public String save(MultipartFile file) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path fileStorageLocation = Paths.get(fileDir).toAbsolutePath().normalize();

            if (fileName.contains("..")) {
                throw new IllegalAccessException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.createFile(targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return targetLocation.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
