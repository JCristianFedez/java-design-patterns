package com.cristian.design.patterns.weapons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrcWeapon implements Weapon {

  private final WeaponType weaponType;

  @Override
  public String toString() {
    return String.format("an orcish %s", this.weaponType);
  }
}
