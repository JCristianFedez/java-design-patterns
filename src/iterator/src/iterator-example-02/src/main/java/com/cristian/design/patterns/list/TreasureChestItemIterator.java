package com.cristian.design.patterns.list;

import java.util.Iterator;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TreasureChestItemIterator implements Iterator<Item> {

  private final TreasureChest chest;

  private final ItemType type;

  private int idx = -1;

  @Override
  public boolean hasNext() {
    return findNextIdx() != -1;
  }

  @Override
  public Item next() {
    this.idx = findNextIdx();
    if (this.idx != -1) {
      return this.chest.getItems().get(this.idx);
    }
    return null;
  }

  private int findNextIdx() {
    final List<Item> items = this.chest.getItems();
    int tempIdx = this.idx;
    while (true) {
      tempIdx++;
      if (tempIdx >= items.size()) {
        return -1;
      }
      if (ItemType.ANY.equals(this.type) || items.get(tempIdx).getType().equals(this.type)) {
        return tempIdx;
      }
    }
  }
}
