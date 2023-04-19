package com.cristian.design.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MementoDemo02 {

  public static void main(String[] args) {
    new MementoDemo02().run();
  }

  private void run() {
    final Deque<StarMemento> states = new ArrayDeque<>();

    final Star star = new Star(StarType.SUN, 10000000, 500000);
    printStarInfo(star);

    passTimeAndSaveMemento(states, star);
    passTimeAndSaveMemento(states, star);
    passTimeAndSaveMemento(states, star);
    passTimeAndSaveMemento(states, star);

    loadMementos(states, star);
  }

  private static void loadMementos(final Deque<StarMemento> states, final Star star) {
    LOGGER.info("LOADING MEMENTOS SAVED");
    while (!states.isEmpty()) {
      star.setMemento(states.pop());
      LOGGER.info(star.toString());
    }
  }

  private void passTimeAndSaveMemento(final Deque<StarMemento> states, final Star star) {
    states.add(star.getMemento());
    star.timePasses();
    printStarInfo(star);
  }

  private void printStarInfo(final Star star) {
    LOGGER.info(star.toString());
  }
}
