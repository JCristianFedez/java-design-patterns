package adapter.ejemplo01.adapters;

import adapter.ejemplo01.adapters.round.RoundHole;
import adapter.ejemplo01.adapters.round.RoundPeg;
import adapter.ejemplo01.adapters.square.SquarePeg;
import commons.logger.Logger;

public class Demo {

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    final RoundHole hole = new RoundHole(5);
    final RoundPeg rPeg = new RoundPeg(5);
    if (hole.fits(rPeg)) {
      LOGGER.debug("RoundPeg r5 cabe en RoundHole r5");
    }

    final SquarePeg smallPeg = new SquarePeg(2);
    final SquarePeg largePeg = new SquarePeg(20);
    //    hole.fits(smallPeg); NO COMPILA

    // Con adapters resolvemos el problema
    final SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallPeg);
    if (hole.fits(smallSqPegAdapter)) {
      LOGGER.debug("Square peg w2 cabe en round hole r5.");
    }

    final SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largePeg);
    if (!hole.fits(largeSqPegAdapter)) {
      LOGGER.debug("Square peg w20 no cabe en round hole r5.");
    }

  }
}
