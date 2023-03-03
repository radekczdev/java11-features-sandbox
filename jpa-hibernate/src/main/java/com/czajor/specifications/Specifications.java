package com.czajor.specifications;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class Specifications {

  public static void main(String[] args) {
    SpringApplication.run(Specifications.class, args);
  }

  private static void findByWatchTimeGreaterEqualsSortByTitle(MovieRepository movieRepository) {
    printStars();

    var timeAndTitle = new MovieSpecification();
    timeAndTitle.add(new SearchCriterion("watchTime", 150, SearchOperation.GREATER_THAN_EQUAL));
    var result = movieRepository.findAll(timeAndTitle, Sort.by("title"));
    System.out.println("Watch time greater/equals 150, sort by title");
    result.forEach(System.out::println);

    printStars();
  }

  private static void findByYearLessThanAndRatingGreaterThan(MovieRepository movieRepository) {
    printStars();

    var releaseAndRating = new MovieSpecification();
    releaseAndRating.add(new SearchCriterion("releaseYear", 2018, SearchOperation.LESS_THAN));
    releaseAndRating.add(new SearchCriterion("rating", 7.9, SearchOperation.GREATER_THAN));
    var result = movieRepository.findAll(releaseAndRating);
    System.out.println("Release year less than 2018 and rating > 7.9");
    result.forEach(System.out::println);

    printStars();
  }

  private static void findByTitleAndRatingGreaterThan(MovieRepository movieRepository) {
    printStars();

    var titleAndRating = new MovieSpecification();
    titleAndRating.add(new SearchCriterion("title", "man", SearchOperation.MATCH));
    titleAndRating.add(new SearchCriterion("rating", 4.5, SearchOperation.GREATER_THAN));
    var result = movieRepository.findAll(titleAndRating);
    System.out.println("Title containing 'man' and rating > 4.5");
    result.forEach(System.out::println);

    printStars();
  }

  private static void findByGenreTest(MovieRepository movieRepository) {
    printStars();

    var genre = new MovieSpecification();
    genre.add(new SearchCriterion("genre", "tv series", SearchOperation.EQUAL));

    var genreResultList = movieRepository.findAll(genre);
    System.out.println("Tv series:");
    genreResultList.forEach(System.out::println);

    printStars();
  }

  private static void printStars() {
    System.out.println("********************************************************************");
  }

  private static void findByTitleDifferentThanAndPaginate(MovieRepository movieRepository) {
    printStars();

    var titleDifferentThan = new MovieSpecification();
    titleDifferentThan.add(new SearchCriterion("title", "Hobbit", SearchOperation.NOT_EQUAL));
    Pageable pageable = PageRequest.of(0, 11, Sort.by("releaseYear").descending());
    var result = movieRepository.findAll(titleDifferentThan, pageable);
    System.out.println("Movies with title different than Hobbit, paged and sorted by release Year");
    result.forEach(System.out::println);

    printStars();
  }

  @Bean
  public CommandLineRunner specificationsTest(MovieRepository movieRepository) {
    return args -> {
      movieRepository.saveAll(List.of(
          new Movie("Hobbit", "Adventure", 6.5, 300, 2012),
          new Movie("Lord of The Rings", "Adventure", 8.5, 180, 2001),
          new Movie("The Office", "tv series", 8, 20, 2005),
          new Movie("Silicon Valley", "tv series", 5.5, 25, 2018),
          new Movie("Spider Man", "action", 5, 180, 2005),
          new Movie("Batman", "action", 6.5, 165, 2005)
      ));

      findByGenreTest(movieRepository);
      findByTitleAndRatingGreaterThan(movieRepository);
      findByYearLessThanAndRatingGreaterThan(movieRepository);
      findByWatchTimeGreaterEqualsSortByTitle(movieRepository);
      findByTitleDifferentThanAndPaginate(movieRepository);

    };
  }

}