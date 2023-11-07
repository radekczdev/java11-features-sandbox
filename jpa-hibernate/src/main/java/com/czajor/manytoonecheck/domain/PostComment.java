package com.czajor.manytoonecheck.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
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

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PostComment that)) {
      return false;
    }
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  public PostComment(String review) {
    this.review = review;
  }
}
