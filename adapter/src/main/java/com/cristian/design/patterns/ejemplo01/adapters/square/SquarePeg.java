package com.cristian.design.patterns.ejemplo01.adapters.square;

/**
 * SquarePegs no son compatibles con RoundHoles (fueron implementados por equipo de desarrollo anterior). Pero tenemos que integrarlos en
 * nuestro programa.
 */
public class SquarePeg {

  private final double width;

  public SquarePeg(double width) {
    this.width = width;
  }

  public double getWidth() {
    return this.width;
  }

  public double getSquare() {
    return Math.pow(this.width, 2);
  }
}
