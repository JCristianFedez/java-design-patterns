package com.cristian.design.patterns.application.repositoris;

import com.cristian.design.patterns.db.FakeDataBase;
import com.cristian.design.patterns.domain.Repository;
import com.cristian.design.patterns.domain.creatures.Wizard;

public class KaerMorhenRepository implements Repository {

  @Override
  public Wizard findWizardById(final long id) {
    return FakeDataBase.getInstance().findWizardById(id);
  }
}
