package com.czajor.specifications;

import static com.czajor.specifications.SearchOperation.EQUAL;
import static com.czajor.specifications.SearchOperation.GREATER_THAN;
import static com.czajor.specifications.SearchOperation.GREATER_THAN_EQUAL;
import static com.czajor.specifications.SearchOperation.IN;
import static com.czajor.specifications.SearchOperation.LESS_THAN;
import static com.czajor.specifications.SearchOperation.LESS_THAN_EQUAL;
import static com.czajor.specifications.SearchOperation.MATCH;
import static com.czajor.specifications.SearchOperation.MATCH_END;
import static com.czajor.specifications.SearchOperation.MATCH_START;
import static com.czajor.specifications.SearchOperation.NOT_EQUAL;
import static com.czajor.specifications.SearchOperation.NOT_IN;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MovieSpecification implements Specification<Movie> {

  public static final char ANY_STRING = '%';
  private final List<SearchCriterion> searchCriteria = new ArrayList<>();

  public void add(SearchCriterion criteria) {
    searchCriteria.add(criteria);
  }

  @Override
  public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    List<Predicate> predicates = new ArrayList<>();

    for (SearchCriterion criterion : searchCriteria) {

      final var criterionValue = criterion.value().toString();
      final Path<String> keyPathString = root.get(criterion.key());

      if (criterion.operation().equals(GREATER_THAN)) {
        predicates.add(builder.greaterThan(keyPathString, criterionValue));
      } else if (criterion.operation().equals(LESS_THAN)) {
        predicates.add(builder.lessThan(keyPathString, criterionValue));
      } else if (criterion.operation().equals(GREATER_THAN_EQUAL)) {
        predicates.add(builder.greaterThanOrEqualTo(keyPathString, criterionValue));
      } else if (criterion.operation().equals(LESS_THAN_EQUAL)) {
        predicates.add(builder.lessThanOrEqualTo(keyPathString, criterionValue));
      } else if (criterion.operation().equals(NOT_EQUAL)) {
        predicates.add(builder.notEqual(keyPathString, criterionValue));
      } else if (criterion.operation().equals(EQUAL)) {
        predicates.add(builder.equal(keyPathString, criterionValue));
      } else if (criterion.operation().equals(MATCH)) {
        predicates.add(builder.like(
            builder.lower(keyPathString),
            '%' + criterionValue.toLowerCase() + '%')
        );
      } else if (criterion.operation().equals(MATCH_END)) {
        predicates.add(builder.like(
            builder.lower(keyPathString),
            criterionValue.toLowerCase() + '%'
        ));
      } else if (criterion.operation().equals(MATCH_START)) {
        predicates.add(builder.like(
            builder.lower(keyPathString),
            ANY_STRING + criterionValue.toLowerCase()
        ));
      } else if (criterion.operation().equals(IN)) {
        predicates.add(builder.in(keyPathString).value(criterionValue));
      } else if (criterion.operation().equals(NOT_IN)) {
        predicates.add(builder.not(
                root.get(criterion.key()))
            .in(criterionValue));
      }
    }
    return builder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
  }
}
