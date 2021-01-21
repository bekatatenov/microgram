package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepositories extends MongoRepository<Subscription, Integer> {

    // find by id

    // list of follows of User

    // list of user's followers
}