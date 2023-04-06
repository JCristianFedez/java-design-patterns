package com.cristian.design.patterns;

import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WithoutThreadLocal extends AbstractThreadLocal {

  private Integer value;

  @Override
  protected Consumer<Integer> setter() {
    return newValue -> this.value = newValue;
  }

  @Override
  protected Supplier<Integer> getter() {
    return () -> this.value;
  }
}
