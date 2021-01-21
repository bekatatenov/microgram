package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositories extends MongoRepository<Post, Integer> {

    // find the Post by id

    // List of Posts of User
    // List of all Posts
}
