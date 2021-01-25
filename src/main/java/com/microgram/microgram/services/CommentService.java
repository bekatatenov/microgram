package com.microgram.microgram.services;

import com.microgram.microgram.repositories.CommentRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    CommentRepositories commentRepositories;
}
