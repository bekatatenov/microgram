package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositories extends JpaRepository<Comment, Integer> {

    // add comment(save)
    // remake comment
    // find by id
    // find by date
    // IsThere any Comment with Date

}