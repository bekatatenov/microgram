package com.microgram.microgram.services;
import com.microgram.microgram.repositories.SubscriptionRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubscriptionService {
    SubscriptionRepositories subscriptionRepositories;
}
