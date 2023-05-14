package com.cristian.design.patterns.application.buses.queries;

import com.cristian.design.patterns.application.handler.query.QueryHandler;
import com.cristian.design.patterns.application.response.Response;
import com.cristian.design.patterns.domain.Query;

public interface QueryBus {

  <R extends Response> R dispatch(Query query);

  void registrarse(Class<? extends Query> query, QueryHandler<?, ? extends Query> handler);

}
