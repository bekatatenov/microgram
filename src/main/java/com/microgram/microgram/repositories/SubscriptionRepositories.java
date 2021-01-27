package com.microgram.microgram.repositories;

import com.microgram.microgram.models.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepositories extends MongoRepository<Subscription, String> {
    List<Subscription> findAllByUserId(String id);
    List<Subscription> findAllByToUserId(String id);

}