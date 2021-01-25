package com.microgram.microgram.services;

import com.microgram.microgram.repositories.CommentRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    CommentRepositories commentRepositories;
}
