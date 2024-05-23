package com.czajor;

import java.util.Map;
import java.util.stream.Collectors;

public class AstroService {
  private final Gateway<AstroResponse> gateway;

  public AstroService(Gateway<AstroResponse> gateway) {
    this.gateway = gateway;
  }

  public Map<String, Long> getAstroData() {
    var response = gateway.getResponse();

    return switch (response) {
      case Success<AstroResponse> success -> extractMap(success.data());
      case Failure<AstroResponse> failure -> throw failure.exception();
    };
  }

  private Map<String, Long> extractMap(AstroResponse data) {
    return data.people().stream()
        .collect(
            Collectors.groupingBy(
                AstroResponse.Assignment::craft,
                Collectors.counting()
            )
        );
  }
}
