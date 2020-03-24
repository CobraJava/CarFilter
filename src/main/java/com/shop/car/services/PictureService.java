package com.shop.car.services;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    String save(MultipartFile file);
}
