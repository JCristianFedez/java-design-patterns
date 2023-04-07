package com.cristian.design.patterns;

import java.util.stream.Stream;

/**
 * Trampoline pattern allows to define recursive algorithms by iterative loop.
 *
 * <p>When get is called on the returned Trampoline, internally it will iterate calling ‘jump’
 * on the returned Trampoline as long as the concrete instance returned is {@link #more(Trampoline)}, stopping once the returned instance is
 * {@link #done(Object)}.
 *
 * <p>Essential we convert looping via recursion into iteration,
 * the key enabling mechanism is the fact that {@link #more(Trampoline)} is a lazy operation.
 *
 * @param <T> is  type for returning result.
 */
@FunctionalInterface
public interface Trampoline<T> {

  /**
   * Created a completed Trampoline.
   *
   * @param result Completed result.
   * @return Completed Trampoline
   */
  static <T> Trampoline<T> done(final T result) {
    return () -> result;
  }

  /**
   * Created a Trampoline that has more work to do.
   *
   * @param trampoline Next stage in Trampoline.
   * @return Trampoline with more work
   */
  static <T> Trampoline<T> more(final Trampoline<Trampoline<T>> trampoline) {
    return Stream.iterate(trampoline, Trampoline::jump)
        .filter(Trampoline::complete)
        .findFirst()
        .map(Trampoline::result)
        .orElse(null);
  }

  T get();

  /**
   * Jump to next stage.
   *
   * @return next stage.
   */
  default Trampoline<T> jump() {
    return this;
  }

  default T result() {
    return get();
  }

  /**
   * Checks if complete.
   *
   * @return true if complete.
   */
  default boolean complete() {
    return true;
  }
}
