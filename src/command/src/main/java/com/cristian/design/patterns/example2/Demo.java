package com.cristian.design.patterns.example2;

import com.cristian.design.patterns.example2.targets.Goblin;
import com.cristian.design.patterns.logger.Logger;

public class Demo {

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    final Wizard wizard = new Wizard();
    final Goblin goblin = new Goblin();

    LOGGER.info("First status");
    goblin.printStatus();

    LOGGER.info("Change size and print status");
    wizard.castSpell(goblin::changeSize);
    goblin.printStatus();

    LOGGER.info("Change visibility and print status");
    wizard.castSpell(goblin::changeVisibility);
    goblin.printStatus();

    LOGGER.info("Undo last spell (last spell is change visibility) and print status");
    wizard.undoLastSpell();
    goblin.printStatus();

    LOGGER.info("Undo last spell (last spell is change size) and print status");
    wizard.undoLastSpell();
    goblin.printStatus();

    LOGGER.info("Redo last spell (last spell is change size) and print status");
    wizard.redoLastSpell();
    goblin.printStatus();

    LOGGER.info("Redo last spell (last spell is change visiblity) and print status");
    wizard.redoLastSpell();
    goblin.printStatus();
  }
}
