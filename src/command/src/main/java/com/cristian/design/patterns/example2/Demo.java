package com.cristian.design.patterns.example2;

import com.cristian.design.patterns.example2.targets.Goblin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static void main(String[] args) {
    final Wizard wizard = new Wizard();
    final Goblin goblin = new Goblin();

    log.info("First status");
    goblin.printStatus();

    log.info("Change size and print status");
    wizard.castSpell(goblin::changeSize);
    goblin.printStatus();

    log.info("Change visibility and print status");
    wizard.castSpell(goblin::changeVisibility);
    goblin.printStatus();

    log.info("Undo last spell (last spell is change visibility) and print status");
    wizard.undoLastSpell();
    goblin.printStatus();

    log.info("Undo last spell (last spell is change size) and print status");
    wizard.undoLastSpell();
    goblin.printStatus();

    log.info("Redo last spell (last spell is change size) and print status");
    wizard.redoLastSpell();
    goblin.printStatus();

    log.info("Redo last spell (last spell is change visiblity) and print status");
    wizard.redoLastSpell();
    goblin.printStatus();
  }
}
