package com.microgram.microgram.repositories;

import com.microgram.microgram.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends MongoRepository<User, Integer> {

    // Find by id, username, email,
    // list of all users


}