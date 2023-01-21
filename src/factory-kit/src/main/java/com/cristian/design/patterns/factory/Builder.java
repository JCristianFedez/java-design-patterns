package com.cristian.design.patterns.factory;

import java.util.function.Supplier;

import com.cristian.design.patterns.wapons.Weapon;
import com.cristian.design.patterns.wapons.WeaponType;

public interface Builder {

  void add(WeaponType type, Supplier<Weapon> supplier);
}
