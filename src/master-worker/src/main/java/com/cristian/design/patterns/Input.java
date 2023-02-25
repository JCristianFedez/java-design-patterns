package com.cristian.design.patterns;

import java.util.List;

/**
 * The abstract Input class, having 1 public field which contains input data, and abstract method divideData.
 *
 * @param <T> T will be type of data.
 */
public abstract class Input<T> {

  protected final T data;

  protected Input(T data) {
    this.data = data;
  }

  public abstract List<Input<T>> divideData(int num);

  public T getData() {
    return this.data;
  }
}
