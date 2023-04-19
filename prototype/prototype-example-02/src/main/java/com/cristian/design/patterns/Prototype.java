package com.cristian.design.patterns;

public abstract class Prototype<T> implements Cloneable {

  @SuppressWarnings("unchecked")
  public T copy() {
    try {
      return (T) clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }
}
