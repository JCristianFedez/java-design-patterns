package com.cristian.design.patterns.mage;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcMage extends Mage {

  private final String weapon;

  public OrcMage(final OrcMage orcBeast) {
    this.weapon = orcBeast.weapon;
  }

  @Override
  public String toString() {
    return String.format("Orcish mage attacks with %s", this.weapon);
  }
}
