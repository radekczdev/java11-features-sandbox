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
    encryptor.setPassword("some-random-password");
    encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

    String privateData = "secret-data";
    String encryptedText = encryptor.encrypt(privateData);
    String plainText = encryptor.decrypt(encryptedText);

    assertNotSame(privateData, encryptedText);
    assertEquals(plainText, privateData);
  }

}