package com.cristian.design.patterns.domain;

import java.util.function.Predicate;

@FunctionalInterface
public interface Filterer<G, E> {

  G by(Predicate<? super E> predicate);
}
