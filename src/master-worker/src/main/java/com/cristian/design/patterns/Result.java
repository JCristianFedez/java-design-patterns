package com.cristian.design.patterns;

/**
 * The abstract Result class, which contains 1 public field containing result data.
 *
 * @param <T> T will be type of data.
 */
public abstract class Result<T> {

  protected final T data;

  protected Result(T data) {
    this.data = data;
  }

  public T getData() {
    return this.data;
  }
}
