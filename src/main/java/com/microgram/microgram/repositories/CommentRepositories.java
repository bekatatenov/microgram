package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepositories extends MongoRepository<Comment, String> {

//    @Query("{'postId': ?0}")
//    Iterable<Comment> findAllByPostId(int postId);

    Slice<Comment> findAllByPostId(Pageable pageable, String postId);

}