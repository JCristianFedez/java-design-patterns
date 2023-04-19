package com.cristian.design.patterns.bst;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TreeNode<T extends Comparable<T>> {

  private final T value;

  private TreeNode<T> left;

  private TreeNode<T> right;

  public T getValue() {
    return this.value;
  }

  public TreeNode<T> getLeft() {
    return this.left;
  }

  public void setLeft(final TreeNode<T> left) {
    this.left = left;
  }

  public TreeNode<T> getRight() {
    return this.right;
  }

  public void setRight(final TreeNode<T> right) {
    this.right = right;
  }

  public void insert(final T valToInsert) {
    final TreeNode<T> parent = getParentNodeOfValueToBeInserted(valToInsert);
    parent.insertNewChild(valToInsert);
  }

  /**
   * Fetch the Parent TreeNode for a given value to insert into the BST.
   *
   * @param valToInsert Value of the new TreeNode to be inserted
   * @return Parent TreeNode of `valToInsert`
   */
  private TreeNode<T> getParentNodeOfValueToBeInserted(final T valToInsert) {
    TreeNode<T> parent = null;
    TreeNode<T> current = this;
    while (current != null) {
      parent = current;
      current = current.traverseOneLevelDown(valToInsert);
    }
    return parent;
  }

  /**
   * Returns left or right child of self based on a value that would be inserted; maintaining the integrity of the BST.
   *
   * @param value The value of the TreeNode that would be inserted beneath self
   * @return The child TreeNode of self which represents the subtree where `value` would be inserted
   */
  private TreeNode<T> traverseOneLevelDown(final T value) {
    return isGreaterThan(value) ? this.left : this.right;
  }

  /**
   * Add a new Child TreeNode of given value to self. WARNING: This method is destructive (will overwrite existing tree structure, if any),
   * and should be called only by this class's insert() method.
   *
   * @param valToInsert Value of the new TreeNode to be inserted
   */
  private void insertNewChild(T valToInsert) {
    if (this.isLessThanOrEqualTo(valToInsert)) {
      this.setRight(new TreeNode<>(valToInsert));
    } else {
      this.setLeft(new TreeNode<>(valToInsert));
    }
  }

  private boolean isGreaterThan(T val) {
    return this.value.compareTo(val) > 0;
  }

  private boolean isLessThanOrEqualTo(T val) {
    return this.value.compareTo(val) < 1;
  }
}
