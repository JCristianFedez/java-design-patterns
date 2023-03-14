package com.cristian.design.patterns;

public class PrivateClassDataDemo {

  public static void main(String[] args) {
    // stew is mutable
    final Stew stew = new Stew(1, 2, 3, 4);
    stew.mix();
    stew.taste();
    stew.mix();

    // immutable stew protected with Private Class Data pattern
    final ImmutableStew immutableStew = new ImmutableStew(2, 4, 3, 6);
    immutableStew.mix();
  }
}
