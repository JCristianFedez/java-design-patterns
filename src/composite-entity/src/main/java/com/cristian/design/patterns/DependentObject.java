package com.cristian.design.patterns;

abstract class DependentObject<T> {

  T data;

  public void setData(final T data) {
    this.data = data;
  }

  public T getData() {
    return this.data;
  }
}
