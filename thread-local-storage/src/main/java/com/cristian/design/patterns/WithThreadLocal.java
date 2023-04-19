package com.cristian.design.patterns;

import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WithThreadLocal extends AbstractThreadLocal {

  private final ThreadLocal<Integer> value;

  public void remove() {
    this.value.remove();
  }

  @Override
  protected Consumer<Integer> setter() {
    return this.value::set;
  }

  @Override
  protected Supplier<Integer> getter() {
    return this.value::get;
  }
}
