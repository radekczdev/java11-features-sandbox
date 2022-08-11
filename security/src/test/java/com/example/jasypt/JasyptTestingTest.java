package com.example.jasypt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;

class JasyptTestingTest {

  @Test
  void useSimpleEncryption() {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
    textEncryptor.setPasswordCharArray("some-random-data".toCharArray());

    String privateData = "secret-data";
    String myEncryptedText = textEncryptor.encrypt(privateData);

    String plainText = textEncryptor.decrypt(myEncryptedText);
    assertEquals(plainText, privateData);
  }

  @Test
  void usingOneWayEncryption() {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    String password = "secret-pass";
    String encryptedPassword = passwordEncryptor.encryptPassword(password);

    boolean result = passwordEncryptor.checkPassword("secret-pass", encryptedPassword);
    assertTrue(result);
  }

  @Test
  void usingOtherAlgorithmEncryption() {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword("test");
    encryptor.setAlgorithm("PBEWithMD5AndDES");

    String privateData = "yPVkWq5UXm4cTeUSMWn0ZCiCf9ecYrVU";
    String encryptedText = encryptor.encrypt(privateData);
    System.out.println(encryptedText);
    String plainText = encryptor.decrypt(encryptedText);

    assertNotSame(privateData, encryptedText);
    assertEquals(plainText, privateData);
  }

}