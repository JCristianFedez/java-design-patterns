package com.cristian.design.patterns;

import com.cristian.design.patterns.blacksmiths.Blacksmith;
import com.cristian.design.patterns.blacksmiths.ElfBlacksmith;
import com.cristian.design.patterns.blacksmiths.OrcBlacksmith;
import com.cristian.design.patterns.weapons.Weapon;
import com.cristian.design.patterns.weapons.WeaponType;

public class Demo {

  private static final String MANUFACTURED = "{} manufactured {}%n";

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final Blacksmith orcBlackSmith = new OrcBlacksmith();
    final Weapon orcSpear = orcBlackSmith.manufactureWeapon(WeaponType.SPEAR);
    print(orcBlackSmith, orcSpear);

    final Weapon orcAxe = orcBlackSmith.manufactureWeapon(WeaponType.AXE);
    print(orcBlackSmith, orcAxe);

    final Blacksmith elfBlacksmith = new ElfBlacksmith();
    final Weapon elfSpear = elfBlacksmith.manufactureWeapon(WeaponType.SPEAR);
    print(elfBlacksmith, elfSpear);

    final Weapon elfAxe = elfBlacksmith.manufactureWeapon(WeaponType.AXE);
    print(elfBlacksmith, elfAxe);
  }

  private void print(final Blacksmith elfBlacksmith, final Weapon elfSpear) {
    System.out.printf(MANUFACTURED, elfBlacksmith, elfSpear);
  }
}
