package com.cristian.design.patterns.user;

public record User(String name) {

  @Override
  public String toString() {
    return this.name;
  }
}
