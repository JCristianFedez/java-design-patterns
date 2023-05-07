package com.cristian.design.patterns.application.handler.query;

import com.cristian.design.patterns.domain.Query;

public interface QueryHandler<Q extends Query> {

  String handle(Q query);
}
