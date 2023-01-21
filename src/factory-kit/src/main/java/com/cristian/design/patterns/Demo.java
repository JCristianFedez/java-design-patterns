package com.cristian.design.patterns;

import java.util.Arrays;

import com.cristian.design.patterns.factory.WeaponFactory;
import com.cristian.design.patterns.weapons.Axe;
import com.cristian.design.patterns.weapons.Bow;
import com.cristian.design.patterns.weapons.Spear;
import com.cristian.design.patterns.weapons.Sword;
import com.cristian.design.patterns.weapons.WeaponType;

public class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final WeaponFactory factory = WeaponFactory.factory(builder -> {
      builder.add(WeaponType.SWORD, Sword::new);
      builder.add(WeaponType.AXE, Axe::new);
      builder.add(WeaponType.SPEAR, Spear::new);
      builder.add(WeaponType.BOW, Bow::new);
    });
    Arrays.asList(factory.create(WeaponType.AXE), factory.create(WeaponType.SPEAR), factory.create(WeaponType.SWORD),
            factory.create(WeaponType.BOW))
        .forEach(System.out::println);
  }
}
