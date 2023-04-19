package com.cristian.design.patterns;

public interface Node {

  String getName();

  int getTreeSize();

  Node getLeft();

  Node getRight();

  void walk();

  boolean isNull();
}
