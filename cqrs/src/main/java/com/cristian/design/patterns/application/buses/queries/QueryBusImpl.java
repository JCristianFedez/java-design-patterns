package com.cristian.design.patterns.application.buses.queries;

import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.application.handler.query.QueryHandler;
import com.cristian.design.patterns.application.response.Response;
import com.cristian.design.patterns.domain.Query;

public final class QueryBusImpl implements QueryBus {

  private final Map<Class<? extends Query>, QueryHandler<?, ? extends Query>> queryHandlers = new HashMap<>();

  @Override
  public <R extends Response> R dispatch(final Query query) {
    final QueryHandler<R, Query> handler = (QueryHandler<R, Query>) this.queryHandlers.get(query.getClass());

    if (handler == null) {
      throw new RuntimeException("No handler found for query of type " + query.getClass().getSimpleName());
    }

    return handler.handle(query);
  }



  @Override
  public void registrarse(final Class<? extends Query> query, final QueryHandler<?, ? extends Query> handler) {
    this.queryHandlers.put(query, handler);
  }
}
