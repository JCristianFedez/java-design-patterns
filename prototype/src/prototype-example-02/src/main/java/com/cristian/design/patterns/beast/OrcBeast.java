package com.cristian.design.patterns.beast;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcBeast extends Beast {

  private final String weapon;

  public OrcBeast(final OrcBeast orcBeast) {
    this.weapon = orcBeast.weapon;
  }

  @Override
  public String toString() {
    return String.format("Orcish wolf attacks with %s", this.weapon);
  }
}
