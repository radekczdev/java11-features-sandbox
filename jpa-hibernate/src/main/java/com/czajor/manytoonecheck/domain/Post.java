package com.czajor.manytoonecheck.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Post")
@Table(name = "post")
@NoArgsConstructor
@Setter
@Getter
public class Post {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  public Post(String title) {
    this.title = title;
  }

}
