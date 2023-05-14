package com.cristian.design.patterns.infrastructure.adapters.primary;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import com.cristian.design.patterns.application.buses.queries.QueryBus;
import com.cristian.design.patterns.application.queries.FindWizardQuery;
import com.cristian.design.patterns.application.requests.FindWizardRequest;
import com.cristian.design.patterns.application.response.FindWizardResponse;

public final class DemoQueryController {

  private final QueryBus queryBus;

  public DemoQueryController(final QueryBus queryBus) {
    this.queryBus = queryBus;
  }

  public FindWizardResponse findWizardSync(final FindWizardRequest request) {
    return findWizard(request);
  }

  public CompletableFuture<FindWizardResponse> findWizardAsync(final ExecutorService executorService, final FindWizardRequest request) {
    final CompletableFuture<FindWizardResponse> future = new CompletableFuture<>();
    executorService.submit(() -> future.complete(findWizard(request)));
    return future;
  }

  private <R> R findWizard(final FindWizardRequest request) {
    final FindWizardQuery query = new FindWizardQuery(request.id());
    return this.queryBus.dispatch(query);
  }
}
