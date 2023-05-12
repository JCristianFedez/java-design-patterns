package com.cristian.design.patterns.application.buses.queries;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import com.cristian.design.patterns.application.handler.query.QueryHandler;
import com.cristian.design.patterns.domain.Query;

public class AsyncQueryBus implements QueryBus<CompletableFuture<String>> {

  private final ExecutorService executorService;

  private final Map<Class<? extends Query>, QueryHandler<? extends Query>> queryHandlers = new ConcurrentHashMap<>();

  public AsyncQueryBus(final ExecutorService executorService) {
    this.executorService = executorService;
  }

  @Override
  public CompletableFuture<String> dispatch(final Query query) {
    final QueryHandler<Query> handler = (QueryHandler<Query>) this.queryHandlers.get(query.getClass());

    if (handler == null) {
      final CompletableFuture<String> future = new CompletableFuture<>();
      future.completeExceptionally(new RuntimeException("No handler found for query of type " + query.getClass().getSimpleName()));
      return future;
    }

    final CompletableFuture<String> future = new CompletableFuture<>();
    this.executorService.execute(() -> future.complete(handler.handle(query)));
    return future;
  }

  @Override
  public void registrarse(final Class<? extends Query> query, final QueryHandler<? extends Query> handler) {
    this.queryHandlers.put(query, handler);
  }
}
