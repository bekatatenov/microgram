package com.microgram.microgram.repositories;

import com.microgram.microgram.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {

    // Find by id, username, email,
    // list of all users


}