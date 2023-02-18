package com.cristian.design.patterns;

import java.util.Collections;
import java.util.Iterator;

import com.cristian.design.patterns.bst.BstIterator;
import com.cristian.design.patterns.bst.TreeNode;
import com.cristian.design.patterns.list.Item;
import com.cristian.design.patterns.list.ItemType;
import com.cristian.design.patterns.list.TreasureChest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IteratorExample02Demo {

  private static final TreasureChest TREASURE_CHEST = new TreasureChest();

  public static void main(String[] args) {
    new IteratorExample02Demo().run();
  }

  private void run() {
    demonstrateTreasureChestIteratorForType(ItemType.RING);
    demonstrateTreasureChestIteratorForType(ItemType.POTION);
    demonstrateTreasureChestIteratorForType(ItemType.WEAPON);
    demonstrateTreasureChestIteratorForType(ItemType.ANY);

    demonstrateBstIterator();
  }

  private void demonstrateTreasureChestIteratorForType(final ItemType type) {
    lineSeparator();
    LOGGER.debug("Item Iterator for ItemType {}", type);
    final Iterator<Item> itemIterator = TREASURE_CHEST.iterator(type);
    itemIterator.forEachRemaining(str -> LOGGER.debug(str.toString()));
  }

  private void demonstrateBstIterator() {
    lineSeparator();
    LOGGER.debug("BST Iterator: ");
    final TreeNode<Integer> root = buildIntegerBst();
    final BstIterator<Integer> bstIterator = new BstIterator<>(root);
    bstIterator.forEachRemaining(node -> LOGGER.debug("Next node: " + node.getValue().toString()));
  }

  private TreeNode<Integer> buildIntegerBst() {
    final TreeNode<Integer> root = new TreeNode<>(8);

    root.insert(3);
    root.insert(10);
    root.insert(1);
    root.insert(6);
    root.insert(14);
    root.insert(4);
    root.insert(7);
    root.insert(13);

    return root;
  }

  private void lineSeparator() {
    LOGGER.debug(String.join("", Collections.nCopies(20, "-")));
  }
}
