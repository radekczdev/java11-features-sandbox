package com.czajor;

public interface Gateway<T> {
  Result<T> getResponse();
}
