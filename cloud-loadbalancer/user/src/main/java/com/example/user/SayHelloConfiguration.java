package com.example.user;

import java.util.List;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

public class SayHelloConfiguration {

  @Bean
  @Primary
  ServiceInstanceListSupplier serviceInstanceListSupplier() {
    return new DemoServiceInstanceListSupplier("say-hello");
  }

}

record DemoServiceInstanceListSupplier(String serviceId) implements ServiceInstanceListSupplier {

  @Override
  public String getServiceId() {
    return this.serviceId;
  }

  @Override
  public Flux<List<ServiceInstance>> get() {
    final var localhost = "localhost";
    return Flux
        .just(List.of(
            new DefaultServiceInstance(this.serviceId + "1", this.serviceId, localhost, 8090, false),
            new DefaultServiceInstance(this.serviceId + "2", this.serviceId, localhost, 9092, false),
            new DefaultServiceInstance(this.serviceId + "3", this.serviceId, localhost, 9999, false)
        ));
  }
}
