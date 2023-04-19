package com.cristian.design.patterns.models;

import com.cristian.design.patterns.stealing.methods.StealingMethod;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HalflingThief {

  private StealingMethod method;

  public void steal() {
    this.method.steal();
  }

  public void changeMethod(final StealingMethod method) {
    this.method = method;
  }
}
