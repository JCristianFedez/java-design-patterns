package com.cristian.design.patterns;

import lombok.AllArgsConstructor;

/**
 * Main Pipeline class that initially sets the current handler. Processed output of the initial handler is then passed as the input to the
 * next stage handlers.
 *
 * @param <I> the type of the input for the first stage handler
 * @param <O> the final stage handler's output type
 */
@AllArgsConstructor
public class Pipeline<I, O> {

  private final Handler<I, O> currentHandler;

  public <K> Pipeline<I, K> addHandler(final Handler<O, K> newHandler) {
    return new Pipeline<>(input -> newHandler.process(this.currentHandler.process(input)));
  }

  public O execute(final I input) {
    return this.currentHandler.process(input);
  }
}
