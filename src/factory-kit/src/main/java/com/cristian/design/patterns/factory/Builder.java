package com.cristian.design.patterns.factory;

import java.util.function.Supplier;

import com.cristian.design.patterns.weapons.Weapon;
import com.cristian.design.patterns.weapons.WeaponType;

public interface Builder {

  void add(WeaponType type, Supplier<Weapon> supplier);
}
