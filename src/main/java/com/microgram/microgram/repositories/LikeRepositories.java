package com.microgram.microgram.repositories;


import com.microgram.microgram.models.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepositories extends MongoRepository<Like, Integer> {
    // findBy id of Post
    // findBy date

    // list of Users who liked the post
    // count of likes List.size
}