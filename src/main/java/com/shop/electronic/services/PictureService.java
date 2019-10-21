package com.shop.electronic.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureService {

    String save(MultipartFile file);
}
