package com.cristian.design.patterns.blacksmiths;

import com.cristian.design.patterns.weapons.Weapon;
import com.cristian.design.patterns.weapons.WeaponType;

public interface Blacksmith {

  Weapon manufactureWeapon(WeaponType type);
}
