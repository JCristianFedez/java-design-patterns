package com.cristian.design.patterns.infrastructure.adapters.primary;

import com.cristian.design.patterns.application.buses.queries.QueryBus;
import com.cristian.design.patterns.application.queries.FindWizardQuery;
import com.cristian.design.patterns.application.requests.FindWizardRequest;

public final class DemoQueryController<R> {

  private final QueryBus<R> queryBus;

  public DemoQueryController(final QueryBus<R> queryBus) {
    this.queryBus = queryBus;
  }

  public R findWizard(final FindWizardRequest request) {
    final FindWizardQuery query = new FindWizardQuery(request.id());
    return this.queryBus.dispatch(query);
  }
}
