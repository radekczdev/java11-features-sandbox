package com.czajor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import org.junit.jupiter.api.Test;

class AstroServiceTest {

  AstroService service;

  @Test
  void testAstroData_RealGateway() {
    service = new AstroService(new AstroGateway());
    Map<String, Long> astroData = service.getAstroData();
    astroData.forEach((craft, number) -> {
      System.out.printf("%d astronauts board %s%n", number, craft);
      assertAll(
          () -> assertThat(number).isPositive(),
          () -> assertThat(craft).isNotBlank(
          ));
    });
  }

}