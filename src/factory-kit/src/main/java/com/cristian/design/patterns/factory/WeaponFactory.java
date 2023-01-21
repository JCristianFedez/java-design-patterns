package com.cristian.design.patterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.cristian.design.patterns.wapons.Weapon;
import com.cristian.design.patterns.wapons.WeaponType;

public interface WeaponFactory {

  static WeaponFactory factory(final Consumer<Builder> consumer) {
    final Map<WeaponType, Supplier<Weapon>> map = new HashMap<>();
    consumer.accept(map::put);
    return type -> map.get(type).get();
  }

  Weapon create(WeaponType type);
}
