package com.cristian.design.patterns.bst;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BstIterator<T extends Comparable<T>> implements Iterator<TreeNode<T>> {

  private final ArrayDeque<TreeNode<T>> pathStack = new ArrayDeque<>();

  public BstIterator(final TreeNode<T> root) {
    pushPathToNextSmallest(root);
  }

  /**
   * This BstIterator manages to use O(h) extra space, where h is the height of the tree It achieves this by maintaining a stack of the
   * nodes to handle (pushing all left nodes first), before handling self or right node.
   *
   * @param node TreeNode that acts as root of the subtree we're interested in.
   */
  private void pushPathToNextSmallest(TreeNode<T> node) {
    while (node != null) {
      pathStack.push(node);
      node = node.getLeft();
    }
  }

  @Override
  public boolean hasNext() {
    return !this.pathStack.isEmpty();
  }

  @Override
  public TreeNode<T> next() {
    if (this.pathStack.isEmpty()) {
      throw new NoSuchElementException();
    }
    final TreeNode<T> next = this.pathStack.pop();
    pushPathToNextSmallest(next.getRight());
    return next;
  }
}
