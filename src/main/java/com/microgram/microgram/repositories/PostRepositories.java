package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositories extends JpaRepository<Post, Integer> {

    // find the Post by id

    // List of Posts of User
    // List of all Posts
}
