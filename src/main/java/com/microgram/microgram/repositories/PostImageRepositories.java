package com.microgram.microgram.repositories;

import com.microgram.microgram.models.PostImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepositories extends MongoRepository<PostImage, String> {
}
