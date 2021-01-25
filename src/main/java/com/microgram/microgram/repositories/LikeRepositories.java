package com.microgram.microgram.repositories;


import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepositories extends MongoRepository<Like, Integer> {

    boolean existsByPostAndAndUser(Optional<Post> post, User user);

    List<Like> findAllByPostId(Integer id);
    List<Like> findAllByUserId(Integer id);
}