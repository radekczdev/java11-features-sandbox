package com.czajor.jwt;

import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

public class JwtEncryptionDecryption {

  public static void main(String[] args) {
    String token = "a.b.c";
    String[] splitted = token.split("\\.");

    var secondPartAsString = decode(splitted[1]).replace("","");
    var secondPartEncoded = encode(secondPartAsString);

    splitted[1] = secondPartEncoded.replaceAll("=","");

    System.out.println(Arrays.stream(splitted).collect(Collectors.joining(".")));

  }

  private static String decode(String encoded) {
    return new String(Base64.getUrlDecoder().decode(encoded));
  }

  private static String encode(String decoded) {
    return Base64.getUrlEncoder().encodeToString(decoded.getBytes());
  }


}
