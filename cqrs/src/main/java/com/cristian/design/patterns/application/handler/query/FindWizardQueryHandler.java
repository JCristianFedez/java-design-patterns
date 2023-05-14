package com.cristian.design.patterns.application.handler.query;

import com.cristian.design.patterns.application.actions.FindWizard;
import com.cristian.design.patterns.application.queries.FindWizardQuery;
import com.cristian.design.patterns.application.response.FindWizardResponse;
import com.cristian.design.patterns.domain.Repository;
import com.cristian.design.patterns.domain.creatures.Wizard;
import com.cristian.design.patterns.domain.valueobjects.WizardId;

public class FindWizardQueryHandler implements QueryHandler<FindWizardResponse, FindWizardQuery> {

  private final Repository repository;

  public FindWizardQueryHandler(final Repository repository) {
    this.repository = repository;
  }

  @Override
  public FindWizardResponse handle(final FindWizardQuery query) {
    final Wizard wizard = new FindWizard(new WizardId(query.id()), this.repository).execute();
    return new FindWizardResponse(wizard.id(), wizard.name());
  }

}
