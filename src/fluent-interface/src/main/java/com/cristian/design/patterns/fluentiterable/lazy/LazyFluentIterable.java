package com.cristian.design.patterns.fluentiterable.lazy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.cristian.design.patterns.fluentiterable.FluentIterable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LazyFluentIterable<T> implements FluentIterable<T> {

  private final Iterable<T> iterable;

  protected LazyFluentIterable() {
    this.iterable = this;
  }

  public static <T> FluentIterable<T> from(final Iterable<T> iterable) {
    return new LazyFluentIterable<>(iterable);
  }

  @Override
  public FluentIterable<T> filter(final Predicate<? super T> predicate) {
    return new LazyFluentIterable<>() {
      @Override
      public Iterator<T> iterator() {
        return new DecoratingIterator<>(iterable.iterator()) {
          @Override
          public T computeNext() {
            while (this.fromIterator.hasNext()) {
              final T candidate = this.fromIterator.next();
              if (predicate.test(candidate)) {
                return candidate;
              }
            }
            return null;
          }
        };
      }
    };
  }

  @Override
  public Optional<T> first() {
    final Iterator<T> resultIterator = first(1).iterator();
    return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
  }

  @Override
  public FluentIterable<T> first(final int count) {
    return new LazyFluentIterable<>() {
      @Override
      public Iterator<T> iterator() {
        return new DecoratingIterator<>(iterable.iterator()) {
          int currentIndex;

          @Override
          public T computeNext() {
            if (this.currentIndex < count && fromIterator.hasNext()) {
              final T candidate = fromIterator.next();
              this.currentIndex++;
              return candidate;
            }
            return null;
          }
        };
      }
    };
  }

  @Override
  public Optional<T> last() {
    final Iterator<T> resultIterator = last(1).iterator();
    return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
  }

  @Override
  public FluentIterable<T> last(final int count) {
    return new LazyFluentIterable<>() {
      @Override
      public Iterator<T> iterator() {
        return new DecoratingIterator<T>(iterable.iterator()) {
          private int stopIndex;

          private int totalElementsCount;

          private List<T> list;

          private int currentIndex;

          @Override
          public T computeNext() {
            initialize();

            while (this.currentIndex < this.stopIndex && fromIterator.hasNext()) {
              this.currentIndex++;
              fromIterator.next();
            }
            if (this.currentIndex >= this.stopIndex && fromIterator.hasNext()) {
              return fromIterator.next();
            }
            return null;
          }

          private void initialize() {
            if (this.list == null) {
              this.list = new ArrayList<>();
              iterable.forEach(this.list::add);
              this.totalElementsCount = this.list.size();
              this.stopIndex = this.totalElementsCount - count;
            }
          }
        };
      }
    };
  }

  @Override
  public <E> FluentIterable<E> map(final Function<? super T, E> function) {
    return new LazyFluentIterable<>() {
      @Override
      public Iterator<E> iterator() {
        return new DecoratingIterator<>(null) {
          final Iterator<T> oldTypeIterator = iterable.iterator();

          @Override
          public E computeNext() {
            if (this.oldTypeIterator.hasNext()) {
              final T candidate = this.oldTypeIterator.next();
              return function.apply(candidate);
            }
            return null;
          }
        };
      }
    };
  }

  @Override
  public List<T> asList() {
    return FluentIterable.copyToList(this.iterable);
  }

  @Override
  public Iterator<T> iterator() {
    return new DecoratingIterator<T>(this.iterable.iterator()) {
      @Override
      public T computeNext() {
        return fromIterator.hasNext() ? fromIterator.next() : null;
      }
    };
  }
}
