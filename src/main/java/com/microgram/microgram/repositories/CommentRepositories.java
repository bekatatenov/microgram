package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepositories extends MongoRepository<Comment, Integer> {

    // add comment(save)
    // remake comment
    // find by id
    // find by date
    // IsThere any Comment with Date

}