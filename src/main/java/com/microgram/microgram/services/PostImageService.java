package com.microgram.microgram.services;


import com.microgram.microgram.dto.PostDto;
import com.microgram.microgram.dto.PostImageDto;
import com.microgram.microgram.exception.ResourceNotFoundException;
import com.microgram.microgram.models.PostImage;
import com.microgram.microgram.repositories.PostImageRepositories;
import org.bson.types.Binary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PostImageService {
    public final PostImageRepositories postImageRepositories;

    public PostImageService(PostImageRepositories postImageRepositories) {
        this.postImageRepositories = postImageRepositories;
    }

    public PostImageDto addImage(MultipartFile file) {
        byte[] data = new byte[0];
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.length == 0) {
            throw new IllegalArgumentException();
            // TODO return no content or something or throw exception
            //  which will be processed on controller layer
        }

        Binary bData = new Binary(data);
        PostImage image = PostImage.builder().postData(bData).build();

        postImageRepositories.save(image);

        return PostImageDto.builder()
                .imageId(image.getId())
                .build();
    }
    public Resource getById(String imageId) {
        PostImage postImage = postImageRepositories.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Post Image with " + imageId + " doesn't exists!"));
        return new ByteArrayResource(postImage.getPostData().getData());
    }
}
