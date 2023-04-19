package com.cristian.design.patterns.threat;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class SimpleThreat implements Threat {

  private final ThreatType type;

  private final int id;

  private final String name;

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public int id() {
    return this.id;
  }

  @Override
  public ThreatType type() {
    return this.type;
  }
}
