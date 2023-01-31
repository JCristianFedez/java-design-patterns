package com.cristian.design.patterns;

abstract class DependentObject<T> {

  T data;

  public T getData() {
    return this.data;
  }

  public void setData(final T data) {
    this.data = data;
  }
}
