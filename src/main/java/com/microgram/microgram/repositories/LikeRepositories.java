package com.microgram.microgram.repositories;


import com.microgram.microgram.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepositories extends JpaRepository<Like, Integer> {
}
