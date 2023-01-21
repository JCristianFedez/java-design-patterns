package com.cristian.design.patterns.weapons;

public record OrcWeapon(WeaponType weaponType) implements Weapon {

  @Override
  public String toString() {
    return String.format("an orcish %s", this.weaponType);
  }
}
