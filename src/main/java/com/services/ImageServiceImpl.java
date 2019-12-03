package com.services;

import com.entity.Card;
import com.entity.Image;
import com.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> uploadImageArrayForCard(MultipartFile[] file, Card card) throws IOException {
        List<Image> result = new ArrayList<>();
        for (MultipartFile mf : file) {
            result.add(imageRepository.save(new Image(mf.getOriginalFilename(), mf.getContentType(), mf.getBytes(), card)));
        }
        return result;
    }

    @Override
    public void deleteByImageId(Long id) {
        imageRepository.deleteById(id);
    }
}
