package com.cristian.design.patterns.beast;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class ElfBeast extends Beast {

  private final String helpType;

  public ElfBeast(final ElfBeast elfBeast) {
    this.helpType = elfBeast.helpType;
  }

  @Override
  public String toString() {
    return String.format("Elven eagle helps in %s", this.helpType);
  }
}
