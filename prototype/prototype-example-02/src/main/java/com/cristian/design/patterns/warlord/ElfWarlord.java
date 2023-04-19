package com.cristian.design.patterns.warlord;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class ElfWarlord extends Warlord {

  private final String helpType;

  public ElfWarlord(final ElfWarlord elfBeast) {
    this.helpType = elfBeast.helpType;
  }

  @Override
  public String toString() {
    return String.format("Elven warlord helps in %s", this.helpType);
  }
}
