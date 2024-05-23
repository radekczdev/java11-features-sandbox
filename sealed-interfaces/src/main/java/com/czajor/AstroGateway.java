package com.czajor;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AstroGateway implements Gateway<AstroResponse> {
  private static final String DEFAULT_URL = "http://api.open-notify.org/astros.json";
  private final String url;

  private final ObjectMapper objectMapper = new ObjectMapper();

  public AstroGateway() {
    this(DEFAULT_URL);
  }

  public AstroGateway(String url) {
    this.url = url;
  }

  @Override
  public Result<AstroResponse> getResponse() {
    try (HttpClient client = HttpClient.newHttpClient()) {
      HttpRequest request = HttpRequest.newBuilder(URI.create(url))
          .header("Accept", "application/json")
          .GET()
          .build();
      HttpResponse<String> httpResponse =
          client.send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println(httpResponse.statusCode());
      return new Success<>(
          objectMapper.readValue(httpResponse.body(), AstroResponse.class)
      );
    } catch (IOException | InterruptedException e) {
      return new Failure<>(new RuntimeException(e));
    }
  }
}
