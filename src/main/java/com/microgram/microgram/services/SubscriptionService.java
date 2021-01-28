package com.microgram.microgram.services;

import com.microgram.microgram.dto.SubscriptionDto;
import com.microgram.microgram.exception.ResourceNotFoundException;
import com.microgram.microgram.models.Subscription;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.SubscriptionRepositories;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class SubscriptionService {
    SubscriptionRepositories subscriptionRepositories;
    UserRepositories userRepositories;

    public SubscriptionDto addSubscription(String userId, String toUserId) {
        User user = userRepositories.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such a user with " + userId + " id"));
        User toUser = userRepositories.findById(toUserId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such a user with " + userId + " id"));
        Subscription subscription = new Subscription(user, toUser, LocalDate.now());
        subscriptionRepositories.save(subscription);
        return SubscriptionDto.from(subscription);
    }

    public boolean deleteSubscription(String subscriptionId) {
        subscriptionRepositories.deleteById(subscriptionId);
        return true;
    }
}
