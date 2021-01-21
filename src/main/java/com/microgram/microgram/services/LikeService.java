package com.microgram.microgram.services;

import com.microgram.microgram.repositories.LikeRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {
    LikeRepositories likeRepositories;


    // there will method, which will add like to post
    // method, which will delete like from post
}
