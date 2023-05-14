package com.cristian.design.patterns.application.handler.query;

import com.cristian.design.patterns.domain.Query;

public interface QueryHandler<R, Q extends Query> {

  R handle(Q query);
}
