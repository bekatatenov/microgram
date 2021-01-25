package com.microgram.microgram.services;
import com.microgram.microgram.repositories.SubscriptionRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscriptionService {
    SubscriptionRepositories subscriptionRepositories;
}
