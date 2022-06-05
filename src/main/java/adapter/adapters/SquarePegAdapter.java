package adapter.adapters;

import adapter.round.RoundPeg;
import adapter.square.SquarePeg;

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
