package com.cristian.design.patterns.example1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
enum Event {
  WHITE_WALKERS_SIGHTED("White walkers sighted"),
  STARK_SIGHTED("Stark sighted"),
  WARSHIPS_APPROACHING("Warships approaching"),
  TRAITOR_DETECTED("Traitor detected");

  private final String description;

  @Override
  public String toString() {
    return this.description;
  }
}
