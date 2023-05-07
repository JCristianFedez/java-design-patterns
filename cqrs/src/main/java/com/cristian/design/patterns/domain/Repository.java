package com.cristian.design.patterns.domain;

import com.cristian.design.patterns.domain.creatures.Wizard;

public interface Repository {

  Wizard findWizardById(long id);
}
