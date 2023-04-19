package com.cristian.design.patterns;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  public void run() {
    final World world = new World();
    Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
      System.out.println("Our world currently has the following countries:-");
      world.fetch().stream().map(country -> "\t" + country).forEach(System.out::print);
      System.out.println();
    }, 0, 15, TimeUnit.SECONDS);
  }
}
