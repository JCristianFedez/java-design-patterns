package com.cristian.design.patterns.application.handler.query;

import com.cristian.design.patterns.application.actions.FindWizard;
import com.cristian.design.patterns.application.queries.FindWizardQuery;
import com.cristian.design.patterns.application.response.FindWizardResponse;
import com.cristian.design.patterns.domain.Repository;
import com.cristian.design.patterns.domain.creatures.Wizard;
import com.cristian.design.patterns.domain.valueobjects.WizardId;
import com.cristian.design.patterns.infrastructure.utils.JsonMapper;

public class FindWizardQueryHandler implements QueryHandler<FindWizardQuery> {

  private final Repository repository;

  public FindWizardQueryHandler(final Repository repository) {
    this.repository = repository;
  }

  @Override
  public String handle(final FindWizardQuery query) {
    final Wizard wizard = new FindWizard(new WizardId(query.id()), this.repository).execute();
    return JsonMapper.serialize(new FindWizardResponse(wizard.id(), wizard.name()));
  }

}
