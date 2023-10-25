package com.czajor.manytoonecheck.service;

import com.czajor.manytoonecheck.domain.Post;
import com.czajor.manytoonecheck.domain.PostComment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Checking {
  private final EntityManager entityManager;

  @Transactional
  public void runChecking() {

    Post post = new Post("First post");

    post.getComments().add(
        new PostComment("My first review")
    );

    post.getComments().add(
        new PostComment("My second review")
    );

    post.getComments().add(
        new PostComment("My third review")
    );

    entityManager.persist(post);
    System.out.println();
  }
}
