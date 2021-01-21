package com.microgram.microgram.services;

import com.microgram.microgram.models.Subscription;
import com.microgram.microgram.repositories.SubscriptionRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscriptionService {
    SubscriptionRepositories subscriptionRepositories;

    // method that will follow to user
    // method what will unfollow to user
    // method that will delete one of the my followers
}
