package com.cristian.design.patterns;

import com.cristian.design.patterns.models.Weapon;

public class UnitOfWorkDemo01 {

  public static void main(String[] args) {
    final Weapon enchantedHammer = new Weapon(1, "Enchanted Hammer");
    final Weapon brokenGreatSword = new Weapon(2, "Broken great sword");
    final Weapon silverTrident = new Weapon(3, "Silver trident");

    final ArmsDealer repository = new ArmsDealer();
    repository.registerNow(enchantedHammer);
    repository.registerModified(brokenGreatSword);
    repository.registerDeleted(silverTrident);
    repository.commit();
  }
}
