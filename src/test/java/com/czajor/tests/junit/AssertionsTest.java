package com.czajor.tests.junit;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

  @Test
  void assertThatWithNulls() {
    String text = null;
    assertThat(text != null);
  }

}
