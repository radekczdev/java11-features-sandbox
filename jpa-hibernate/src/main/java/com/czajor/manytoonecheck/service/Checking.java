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

    post.addComment(
        new PostComment("My first review")
    );

    post.addComment(
        new PostComment("My second review")
    );

    post.addComment(
        new PostComment("My third review")
    );

    entityManager.persist(post);

    Post post1 = entityManager.find(Post.class, 1);
    PostComment comment = post1.getComments().get(0);

    post1.removeComment(comment);
  }
}
