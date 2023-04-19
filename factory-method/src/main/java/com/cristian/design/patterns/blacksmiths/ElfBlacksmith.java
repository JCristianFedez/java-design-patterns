package com.cristian.design.patterns.blacksmiths;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import com.cristian.design.patterns.weapons.ElfWeapon;
import com.cristian.design.patterns.weapons.Weapon;
import com.cristian.design.patterns.weapons.WeaponType;

public class ElfBlacksmith implements Blacksmith {

  private static final Map<WeaponType, ElfWeapon> ELF_ARSENAL;

  static {
    ELF_ARSENAL = new EnumMap<>(WeaponType.class);
    Arrays.stream(WeaponType.values()).forEach(type -> ELF_ARSENAL.put(type, new ElfWeapon(type)));
  }

  @Override
  public Weapon manufactureWeapon(final WeaponType type) {
    return ELF_ARSENAL.get(type);
  }

  @Override
  public String toString() {
    return "The elf blacksmith";
  }
}
