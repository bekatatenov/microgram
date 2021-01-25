package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositories extends MongoRepository<Post, Integer> {
    List<Post> findAllByUserId(Integer id);
    Post findPostById(Integer id);
}