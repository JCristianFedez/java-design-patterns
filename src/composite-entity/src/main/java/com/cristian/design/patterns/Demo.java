package com.cristian.design.patterns;

class Demo {

  public static void main(String[] args) {
    final CompositeEntity console = new CompositeEntity();
    console.init();
    console.setData("No Danger", "Green Light");
    console.getData().forEach(System.out::println);
    System.out.println("==================");
    console.setData("Danger", "Red Light");
    console.getData().forEach(System.out::println);
  }
}
