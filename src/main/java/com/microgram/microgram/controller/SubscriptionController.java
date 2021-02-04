package com.microgram.microgram.controller;

import com.microgram.microgram.dto.SubscriptionDto;
import com.microgram.microgram.models.Subscription;
import com.microgram.microgram.models.User;
import com.microgram.microgram.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/{id}")
    public SubscriptionDto addSubs(@PathVariable String id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return subscriptionService.addSubscription(user.getId(), id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubs(@PathVariable String id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Subscription subs = subscriptionService.findById(id);

        if (subs.getUser().getId().equals(user.getId())) {
            if (subscriptionService.deleteSubscription(id)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}