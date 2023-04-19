package com.cristian.design.patterns.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Item {

  private final String name;

  @Getter
  @Setter
  private ItemType type;

  @Override
  public String toString() {
    return this.name;
  }
}
