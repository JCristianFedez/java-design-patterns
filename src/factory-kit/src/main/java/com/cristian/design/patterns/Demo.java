package com.cristian.design.patterns;

import java.util.Arrays;

import com.cristian.design.patterns.factory.WeaponFactory;
import com.cristian.design.patterns.wapons.Axe;
import com.cristian.design.patterns.wapons.Bow;
import com.cristian.design.patterns.wapons.Spear;
import com.cristian.design.patterns.wapons.Sword;
import com.cristian.design.patterns.wapons.WeaponType;

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
