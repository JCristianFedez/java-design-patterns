package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Validator<T> {

  private final T objToValidate;

  private final List<Throwable> exceptions = new ArrayList<>();

  private Validator(final T objToValidate) {
    this.objToValidate = objToValidate;
  }

  public static <T> Validator<T> of(final T objToValidate) {
    return new Validator<>(Objects.requireNonNull(objToValidate));
  }

  public Validator<T> validate(final Predicate<? super T> validation, final String msg) {
    if (!validation.test(this.objToValidate)) {
      this.exceptions.add(new IllegalArgumentException(msg));
    }
    return this;
  }

  /**
   * Extension for the {@link Validator#validate(Predicate, String)} method, dedicated for objects, that need to be projected before
   * requested validation.
   */
  public <U> Validator<T> validate(
      final Function<? super T, ? extends U> projection,
      final Predicate<? super U> validation,
      final String msg
  ) {
    return validate(projection.andThen(validation::test)::apply, msg);
  }

  public T get() {
    if (this.exceptions.isEmpty()) {
      return this.objToValidate;
    }
    final IllegalArgumentException exception = new IllegalArgumentException();
    this.exceptions.forEach(exception::addSuppressed);
    throw exception;
  }
}
