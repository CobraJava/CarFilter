package com.shop.car.services;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {

    private static final Map<Object, Object> CONFIG = new HashMap<>();

    static {
        CONFIG.put("cloud_name", "dzedey9gx");
        CONFIG.put("api_key", "783166578794438");
        CONFIG.put("api_secret", "1mdNYbco532G0jkCQLaklWSH9lc");
    }

    private Cloudinary cloudinary = new Cloudinary(CONFIG);

    @Override
    public String save(MultipartFile file) {

        @SuppressWarnings("rawtypes")
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("use_filename", "true", "unique_filename", "true"));
        } catch (IOException e) {
            System.err.println("Could not upload files.");
        }
        return (String) uploadResult.get("url");
    }
}
