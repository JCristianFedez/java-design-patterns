package com.cristian.design.patterns;

public class NullObjectDemo {

  public static void main(String[] args) {
    new NullObjectDemo().run();
  }

  private void run() {
    final Node root = new NodeImpl("1",
        new NodeImpl("11",
            new NodeImpl("111", NullNode.getInstance(), NullNode.getInstance()),
            NullNode.getInstance()
        ),
        new NodeImpl("12",
            NullNode.getInstance(),
            new NodeImpl("122", NullNode.getInstance(), NullNode.getInstance())
        )
    );

    root.walk();
  }
}
