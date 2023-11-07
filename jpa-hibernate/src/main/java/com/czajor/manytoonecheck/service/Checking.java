package com.czajor.manytoonecheck.service;

import com.czajor.manytoonecheck.domain.Post;
import com.czajor.manytoonecheck.domain.PostComment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Checking {
  private final EntityManager entityManager;

  @Transactional
  public void runChecking() {
    Post post = new Post("First post");

    PostComment pc1 = new PostComment("My first review");
    pc1.setPost(post);

    PostComment pc2 = new PostComment("My second review");
    pc2.setPost(post);

    PostComment pc3 = new PostComment("My third review");
    pc3.setPost(post);

    entityManager.persist(post);
    entityManager.persist(pc1);
    entityManager.persist(pc2);
    entityManager.persist(pc3);

    List<PostComment> comments = entityManager.createQuery(
            """
                select pc
                from PostComment pc
                where pc.post.id = :postId
                """, PostComment.class)
        .setParameter("postId", 1L)
        .getResultList();

    System.out.println(comments.size());

  }
}
