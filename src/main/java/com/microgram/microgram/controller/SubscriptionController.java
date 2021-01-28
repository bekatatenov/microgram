package com.microgram.microgram.controller;

import com.microgram.microgram.dto.SubscriptionDto;
import com.microgram.microgram.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/{id}")
    public SubscriptionDto addSubs(@PathVariable String id, @RequestParam("userID") String userId) {
        return subscriptionService.addSubscription(userId, id);
    }
}