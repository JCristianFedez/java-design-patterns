package com.cristian.design.patterns.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreasureChest {

  private final List<Item> items;

  public TreasureChest() {
    items = List.of(
        new Item("Potion of courage", ItemType.POTION),
        new Item("Ring of shadows", ItemType.RING),
        new Item("Potion of wisdom", ItemType.POTION),
        new Item("Potion of blood", ItemType.POTION),
        new Item("Sword of silver + 1", ItemType.WEAPON),
        new Item("Potion of rust", ItemType.POTION),
        new Item("Potion of healing", ItemType.POTION),
        new Item("Ring of armor", ItemType.RING),
        new Item("Steel halberd", ItemType.WEAPON),
        new Item("Dagger of poison", ItemType.WEAPON));
  }

  public Iterator<Item> iterator(final ItemType itemType) {
    return new TreasureChestItemIterator(this, itemType);
  }

  public List<Item> getItems() {
    return new ArrayList<>(this.items);
  }
}
