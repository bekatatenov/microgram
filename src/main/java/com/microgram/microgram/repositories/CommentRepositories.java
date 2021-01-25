package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepositories extends MongoRepository<Comment, Integer> {

    @Query("{'postId': ?0}")
    Iterable<Comment> findAllByPostId(int postId);
}