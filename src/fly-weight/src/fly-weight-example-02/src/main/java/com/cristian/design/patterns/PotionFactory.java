package com.cristian.design.patterns;

import java.util.EnumMap;
import java.util.Map;

import com.cristian.design.patterns.potions.HealingPotion;
import com.cristian.design.patterns.potions.HolyWaterPotion;
import com.cristian.design.patterns.potions.InvisibilityPotion;
import com.cristian.design.patterns.potions.PoisonPotion;
import com.cristian.design.patterns.potions.Potion;
import com.cristian.design.patterns.potions.StrenghtPotion;

public class PotionFactory {

  private final Map<PotionType, Potion> potions = new EnumMap<>(PotionType.class);

  Potion createPotion(final PotionType type) {
    Potion potion = this.potions.get(type);
    if (potion == null) {
      switch (type) {
        case HEALING -> potion = new HealingPotion();
        case HOLY_WATER -> potion = new HolyWaterPotion();
        case INVISIBILITY -> potion = new InvisibilityPotion();
        case POISON -> potion = new PoisonPotion();
        case STRENGTH -> potion = new StrenghtPotion();
        default -> throw new IllegalStateException("Unexpected value: " + type);
      }
      this.potions.put(type, potion);
    }
    return potion;
  }

}
