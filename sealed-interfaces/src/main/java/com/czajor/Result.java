package com.czajor;

public sealed interface Result<T>
    permits Failure, Success {
}

record Success<T>(T data) implements Result<T> {
}

record Failure<T>(RuntimeException exception) implements Result<T> {
}
