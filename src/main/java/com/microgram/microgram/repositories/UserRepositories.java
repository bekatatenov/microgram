package com.microgram.microgram.repositories;

import com.microgram.microgram.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositories extends MongoRepository<User, Integer> {
    List<User> findByName(String name);
    User findByLogin(String login);
    User findByEmail(String email);
    User findUserById(Integer id);
    boolean existsByEmail(String email);
}