package com.microgram.microgram.repositories;

import com.microgram.microgram.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositories extends MongoRepository<User, String> {
    List<User> findByName(String name);
    User findByLogin(String login);
    User findUserById(String id);
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    Optional<User> findByEmail(String s);
}