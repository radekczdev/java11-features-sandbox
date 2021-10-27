package com.czajor.tests.javabasics;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppendNullToStringBuilderTest {

  @InjectMocks
  private AppendNullToStringBuilder appendNullToStringBuilder;

  @Mock
  private ClassWithText classWithText;

  @Mock
  private ClassWithText.InternalValues internalValues;

  @Test
  void shouldNotThrowExceptionOnAppendNullOperation() {
    when(classWithText.getInternalValues()).thenReturn(internalValues);
    var result = appendNullToStringBuilder.appendText();
    assert result != null;
  }
}