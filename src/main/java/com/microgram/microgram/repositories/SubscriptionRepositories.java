package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepositories extends JpaRepository<Subscription, Integer> {

    // find by id

    // list of follows of User

    // list of user's followers
}