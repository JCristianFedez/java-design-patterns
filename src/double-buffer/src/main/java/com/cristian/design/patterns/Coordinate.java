package com.cristian.design.patterns;

public class Coordinate {

  private final int cordX;

  private final int cordY;

  public Coordinate(final int cordX, final int cordY) {
    this.cordX = cordX;
    this.cordY = cordY;
  }

  public int getCordX() {
    return this.cordX;
  }

  public int getCordY() {
    return this.cordY;
  }
}
