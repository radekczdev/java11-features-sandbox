package com.czajor.manytoonecheck.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PostComment")
@Table(name = "post_comment")
@NoArgsConstructor
@Getter
@Setter
public class PostComment {

  @Id
  @GeneratedValue
  private Long id;

  private String review;

  public PostComment(String review) {
    this.review = review;
  }
}
