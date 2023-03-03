package com.czajor.specifications;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private String genre;
  private double rating;
  private double watchTime;
  private int releaseYear;
  public Movie(String title, String genre, double rating, double watchTime, int releaseYear) {
    this.title = title;
    this.genre = genre;
    this.rating = rating;
    this.watchTime = watchTime;
    this.releaseYear = releaseYear;
  }

}
