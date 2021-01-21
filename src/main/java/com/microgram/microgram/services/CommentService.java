package com.microgram.microgram.services;

import com.microgram.microgram.repositories.CommentRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    CommentRepositories commentRepositories;

    // method  find comments by post
    // method  change comment by user and post
    // delete comment
}
