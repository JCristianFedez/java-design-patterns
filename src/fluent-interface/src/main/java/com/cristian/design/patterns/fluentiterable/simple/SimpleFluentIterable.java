package com.cristian.design.patterns.fluentiterable.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.cristian.design.patterns.fluentiterable.FluentIterable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleFluentIterable<T> implements FluentIterable<T> {

  private final Iterable<T> iterable;

  public static <T> List<T> toList(final Iterator<T> iterator) {
    final List<T> copy = new ArrayList<>();
    iterator.forEachRemaining(copy::add);
    return copy;

  }

  public static <T> FluentIterable<T> from(final Iterable<T> iterable) {
    return new SimpleFluentIterable<>(iterable);
  }

  public static <T> FluentIterable<T> fromCopyOf(final Iterable<T> iterable) {
    final List<T> copy = FluentIterable.copyToList(iterable);
    return new SimpleFluentIterable<>(copy);
  }

  @Override
  public FluentIterable<T> filter(final Predicate<? super T> predicate) {
    final Iterator<T> iterator = iterator();
    while (iterator.hasNext()) {
      if (!predicate.test(iterator.next())) {
        iterator.remove();
      }
    }
    return this;
  }

  @Override
  public Optional<T> first() {
    final Iterator<T> resultIterator = first(1).iterator();
    return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
  }

  @Override
  public FluentIterable<T> first(final int count) {
    final Iterator<T> iterator = iterator();
    int currentCount = 0;
    while (iterator.hasNext()) {
      iterator.next();
      if (currentCount >= count) {
        iterator.remove();
      }
      currentCount++;
    }
    return this;
  }

  @Override
  public Optional<T> last() {
    final List<T> list = last(1).asList();
    return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
  }

  @Override
  public FluentIterable<T> last(final int count) {
    final int remainingElementsCount = remainingElementsCount();
    final Iterator<T> iterator = iterator();
    int currentIndex = 0;
    while (iterator.hasNext()) {
      iterator.next();
      if (currentIndex < remainingElementsCount - count) {
        iterator.remove();
      }
      currentIndex++;
    }
    return this;
  }

  @Override
  public <E> FluentIterable<E> map(final Function<? super T, E> function) {
    final List<E> tempList = new ArrayList<>();
    this.forEach(t -> tempList.add(function.apply(t)));
    return from(tempList);
  }

  @Override
  public List<T> asList() {
    return toList(this.iterable.iterator());
  }

  @Override
  public Iterator<T> iterator() {
    return this.iterable.iterator();
  }

  @Override
  public void forEach(final Consumer<? super T> action) {
    this.iterable.forEach(action);
  }

  @Override
  public Spliterator<T> spliterator() {
    return this.iterable.spliterator();
  }

  public final int remainingElementsCount() {
    int counter = 0;
    for (final T ignored : this) {
      counter++;
    }
    return counter;
  }
}
