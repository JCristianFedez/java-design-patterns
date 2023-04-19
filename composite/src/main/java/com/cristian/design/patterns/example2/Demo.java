package com.cristian.design.patterns.example2;

final class Demo {

  public static void main(String[] args) {
    final Messenger messenger = new Messenger();

    System.out.println("Message from the orcs: ");
    messenger.messageFromOrcs().print();

    System.out.println("\nMessage from the elves: ");
    messenger.messageFromElves().print();
  }
}
