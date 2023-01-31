package com.cristian.design.patterns;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.Random;

import com.cristian.design.patterns.forest.Forest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  private static final int CANVAS_SIZE = 500;

  private static final int TREES_TO_DRAW = 1000000;

  private static final int TREE_TYPES = 2;

  private static final Random random = new SecureRandom();

  public static void main(String[] args) {
    final Forest forest = new Forest();
    for (int i = 0; i < (TREES_TO_DRAW / TREE_TYPES); i++) {
      forest.plantTree(random(), random(), "Summer Oak", Color.GREEN, "Oak texture stub");
      forest.plantTree(random(), random(), "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
    }
    forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
    forest.setVisible(true);

    log.debug(TREES_TO_DRAW + " trees drawn");
    log.debug("---------------------");
    log.debug("Memory usage:");
    log.debug("Tree size (8 bytes) * " + TREES_TO_DRAW);
    log.debug("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
    log.debug("---------------------");
    log.debug(
        "Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) + "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024)
            + "MB)");
  }

  private static int random() {
    return random.nextInt(Demo.CANVAS_SIZE);
  }
}
