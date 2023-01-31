package com.cristian.design.patterns.ejemplo01.adapters;

import com.cristian.design.patterns.ejemplo01.adapters.round.RoundHole;
import com.cristian.design.patterns.ejemplo01.adapters.round.RoundPeg;
import com.cristian.design.patterns.ejemplo01.adapters.square.SquarePeg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static void main(String[] args) {
    final RoundHole hole = new RoundHole(5);
    final RoundPeg rPeg = new RoundPeg(5);
    if (hole.fits(rPeg)) {
      log.debug("RoundPeg r5 cabe en RoundHole r5");
    }

    final SquarePeg smallPeg = new SquarePeg(2);
    final SquarePeg largePeg = new SquarePeg(20);
    //    hole.fits(smallPeg); NO COMPILA

    // Con adapters resolvemos el problema
    final SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallPeg);
    if (hole.fits(smallSqPegAdapter)) {
      log.debug("Square peg w2 cabe en round hole r5.");
    }

    final SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largePeg);
    if (!hole.fits(largeSqPegAdapter)) {
      log.debug("Square peg w20 no cabe en round hole r5.");
    }

  }
}
