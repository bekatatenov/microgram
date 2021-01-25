package com.microgram.microgram.repositories;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositories extends MongoRepository<Post, Integer> {
    Post findByUser(User user);

    //    @Query("{'user':{'$ne':?0 }}")
    List<Post> findByUserNotContains(User user);
    List<Post> findAllByUserId(Integer id);
}