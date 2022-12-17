package com.cristian.design.patterns;

public class Demo {

  public static void main(String[] args) {
    final Caretaker caretaker = new Caretaker();

    final Originator originator = new Originator();
    originator.setState("Estado 1");
    originator.setState("Estado 2");
    caretaker.addMemento(originator.saveToMemento());
    originator.setState("Estado 3");
    caretaker.addMemento(originator.saveToMemento());
    originator.setState("Estado 4");

    originator.restoreToMemento(caretaker.getMemento(1));
  }
}
