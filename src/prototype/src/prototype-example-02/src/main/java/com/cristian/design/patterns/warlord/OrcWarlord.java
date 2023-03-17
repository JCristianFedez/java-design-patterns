package com.cristian.design.patterns.warlord;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcWarlord extends Warlord {

  private final String weapon;

  public OrcWarlord(final OrcWarlord orcBeast) {
    this.weapon = orcBeast.weapon;
  }

  @Override
  public String toString() {
    return String.format("Orcish warlord attacks with %s", this.weapon);
  }
}
