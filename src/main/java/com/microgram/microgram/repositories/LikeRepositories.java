package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepositories extends MongoRepository<Like, String> {

    boolean existsLikeByUserAndPost(User user, Post post);
}