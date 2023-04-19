package com.cristian.design.patterns.fluentiterable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FluentIterable<T> extends Iterable<T> {

  static <T> List<T> copyToList(final Iterable<T> iterable) {
    final List<T> copy = new ArrayList<>();
    iterable.forEach(copy::add);
    return copy;
  }

  FluentIterable<T> filter(Predicate<? super T> predicate);

  Optional<T> first();

  FluentIterable<T> first(int count);

  Optional<T> last();

  FluentIterable<T> last(int count);

  <E> FluentIterable<E> map(Function<? super T, E> function);

  List<T> asList();
}
