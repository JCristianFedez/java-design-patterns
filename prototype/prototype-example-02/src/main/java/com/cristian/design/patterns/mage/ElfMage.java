package com.cristian.design.patterns.mage;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class ElfMage extends Mage {

  private final String helpType;

  public ElfMage(final ElfMage elfBeast) {
    this.helpType = elfBeast.helpType;
  }

  @Override
  public String toString() {
    return String.format("Elven mage helps in %s", this.helpType);
  }
}
