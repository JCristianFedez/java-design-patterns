package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Getter
public class NodeImpl implements Node {

  private final String name;

  private final Node left;

  private final Node right;

  @Override
  public int getTreeSize() {
    return 1 + this.left.getTreeSize() + this.right.getTreeSize();
  }

  @Override
  public void walk() {
    LOGGER.info(getName());
    if (getLeft().getTreeSize() > 0) {
      getLeft().walk();
    }
    if (getRight().getTreeSize() > 0) {
      getRight().walk();
    }
  }

  @Override
  public boolean isNull() {
    return false;
  }
}
