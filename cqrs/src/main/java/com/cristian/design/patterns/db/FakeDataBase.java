package com.cristian.design.patterns.db;

import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.domain.creatures.Wizard;

/**
 * Class that simulate a DB.
 */
public class FakeDataBase {

  private static FakeDataBase instance;

  private final Map<Long, Wizard> wizards = new HashMap<>();

  private FakeDataBase() {
    for (long i = 1; i <= 5; i++) {
      this.wizards.put(i, new Wizard(i, String.format("Wizard %s", i)));
    }
  }

  public Wizard findWizardById(final long id) {
    return this.wizards.get(id);
  }

  public static FakeDataBase getInstance() {
    if (instance == null) {
      instance = new FakeDataBase();
    }
    return instance;
  }
}
