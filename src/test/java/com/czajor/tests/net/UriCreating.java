package com.czajor.tests.net;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class UriCreating {

  @Test
  void isProperlyEncoded() {
    var wescaleUri = "https://bosch-dev.wescale.io";
    var shoppingCartUri = "/shopping/#/carts/{cartId}";
    final var cartId = "8c98943d-dbf3-4117-9f16-18b25b28ce97";
    URI uri = UriComponentsBuilder.fromHttpUrl(wescaleUri + shoppingCartUri)
        .build(cartId);

    String variable = URLDecoder.decode(uri.toString(), StandardCharsets.UTF_8);

    System.out.println(uri);
    assertEquals((wescaleUri + shoppingCartUri).replace("{cartId}", cartId), variable);
  }
}
