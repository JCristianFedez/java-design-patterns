package com.cristian.design.patterns.fluentiterable.lazy;

import java.util.Iterator;

public abstract class DecoratingIterator<E> implements Iterator<E> {

  protected final Iterator<E> fromIterator;

  private E next;

  protected DecoratingIterator(final Iterator<E> fromIterator) {
    this.fromIterator = fromIterator;
  }

  @Override
  public final boolean hasNext() {
    this.next = computeNext();
    return next != null;
  }

  @Override
  public E next() {
    if (this.next == null) {
      return this.fromIterator.next();
    } else {
      final E result = this.next;
      this.next = null;
      return result;
    }
  }

  /**
   * Computes the next object of the Iterable. Can be implemented to realize custom behaviour for an iteration process, null is considered
   * as end of data.
   *
   * @return The next element of the Iterable.
   */
  public abstract E computeNext();
}
