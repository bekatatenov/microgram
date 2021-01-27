package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositories extends MongoRepository<Post, String> {
    List<Post> findAllByUserId(String id);

    Post findPostById(String id);

    Page<Post> findAllByUserEmail(Pageable pageable, String userEmail);
}