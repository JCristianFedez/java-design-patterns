package com.cristian.design.patterns;

public class Demo {

  public static void main(String[] args) {
    final ConfigureForUnixVisitor configureForUnixVisitor = new ConfigureForUnixVisitor();
    final ConfigureForDOSVisitor configureForDOSVisitor = new ConfigureForDOSVisitor();
    final Zoom zoom = new Zoom();
    final Hayes hayes = new Hayes();

    hayes.accept(configureForDOSVisitor);
    zoom.accept(configureForDOSVisitor);

    hayes.accept(configureForUnixVisitor);
    zoom.accept(configureForUnixVisitor);
  }
}
