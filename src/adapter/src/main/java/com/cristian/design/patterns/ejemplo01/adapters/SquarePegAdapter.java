package com.cristian.design.patterns.ejemplo01.adapters;

import com.cristian.design.patterns.ejemplo01.adapters.round.RoundPeg;
import com.cristian.design.patterns.ejemplo01.adapters.square.SquarePeg;

/**
 * El adaptador permite colocar SquarePegs en RoundHoles.
 */
public class SquarePegAdapter extends RoundPeg {
  private final SquarePeg peg;

  public SquarePegAdapter(SquarePeg peg) {
    this.peg = peg;
  }

  @Override
  public double getRadius() {
    final double pow = Math.pow((peg.getWidth() / 2), 2);
    return Math.sqrt(pow * 2);
  }
}
