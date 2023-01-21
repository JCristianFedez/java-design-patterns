package com.cristian.design.patterns.weapons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ElfWeapon implements Weapon {

  private final WeaponType weaponType;

  @Override
  public String toString() {
    return String.format("an elven %s", this.weaponType);
  }
}
