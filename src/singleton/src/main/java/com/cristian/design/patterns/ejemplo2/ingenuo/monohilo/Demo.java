package com.cristian.design.patterns.ejemplo2.ingenuo.monohilo;

public class Demo {

  public static void main(String[] args) {
    final Singleton firstSingleton = Singleton.getInstance(2);
    final Singleton secondSingleton = Singleton.getInstance();
    final Singleton thirdSingleton = Singleton.getInstance(5);

    printSingletons(firstSingleton, secondSingleton, thirdSingleton);

    firstSingleton.setValue(20);
    printSingletons(firstSingleton, secondSingleton, thirdSingleton);

    secondSingleton.setValue(30);
    printSingletons(firstSingleton, secondSingleton, thirdSingleton);

    secondSingleton.setValue(40);
    printSingletons(firstSingleton, secondSingleton, thirdSingleton);
  }

  private static void printSingletons(final Singleton firstSingleton, final Singleton secondSingleton, final Singleton thirdSingleton) {
    System.out.println("firstSingleton = " + firstSingleton.getValue());
    System.out.println("secondSingleton = " + secondSingleton.getValue());
    System.out.println("thirdSingleton = " + thirdSingleton.getValue());
    System.out.println("=========================================");
  }

}