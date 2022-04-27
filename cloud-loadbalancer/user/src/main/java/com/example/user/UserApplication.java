package com.example.user;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

@SpringBootApplication
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UserApplication {

  private final WebClient.Builder loadBalancedWebClientBuilder;
  private final ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction;

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

  @RequestMapping("/hi")
  public Flux<String> hi(@RequestParam(value = "name", defaultValue = "Radek") String name) {
    return loadBalancedWebClientBuilder
        .build()
        .get()
        .uri("http://say-hello/greeting")
        .retrieve()
        .bodyToFlux(String.class)
        .repeatWhen(Repeat.times(Long.MAX_VALUE).fixedBackoff(Duration.ofSeconds(1)))
        .map(greeting -> String.format("%s, %s!", greeting, name));
  }

  @RequestMapping("/hello")
  public Mono<String> hello(@RequestParam(value = "name", defaultValue = "John") String name) {
    return WebClient
        .builder()
        .filter(loadBalancerExchangeFilterFunction)
        .build()
        .get()
        .uri("http://say-hello/greeting")
        .retrieve()
        .bodyToMono(String.class)
        .map(greeting -> String.format("%s, %s!", greeting, name));
  }
}
