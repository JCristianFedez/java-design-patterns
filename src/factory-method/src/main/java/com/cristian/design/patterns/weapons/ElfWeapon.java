package com.cristian.design.patterns.weapons;

public record ElfWeapon(WeaponType weaponType) implements Weapon {

  @Override
  public String toString() {
    return String.format("an elven %s", this.weaponType);
  }
}
