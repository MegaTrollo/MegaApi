package com.services;

import com.entity.Card;
import com.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    List<Image> uploadImageArrayForCard(MultipartFile[] file, Card card) throws IOException;

    // List<Image> uploadImageArrayForComment(MultipartFile[] file, Comment comment) throws IOException;

    void deleteByImageId(Long id);
}
