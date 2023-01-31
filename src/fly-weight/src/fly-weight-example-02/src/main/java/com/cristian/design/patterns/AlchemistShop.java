package com.cristian.design.patterns;

import java.util.List;

import com.cristian.design.patterns.potions.Potion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlchemistShop {

  private final List<Potion> topShelf;

  private final List<Potion> bottomShelf;

  public AlchemistShop() {
    final PotionFactory factory = new PotionFactory();
    this.topShelf = List.of(
        factory.createPotion(PotionType.INVISIBILITY),
        factory.createPotion(PotionType.INVISIBILITY),
        factory.createPotion(PotionType.STRENGTH),
        factory.createPotion(PotionType.HEALING),
        factory.createPotion(PotionType.INVISIBILITY),
        factory.createPotion(PotionType.STRENGTH),
        factory.createPotion(PotionType.HEALING),
        factory.createPotion(PotionType.HEALING)
    );
    this.bottomShelf = List.of(
        factory.createPotion(PotionType.POISON),
        factory.createPotion(PotionType.POISON),
        factory.createPotion(PotionType.POISON),
        factory.createPotion(PotionType.HOLY_WATER),
        factory.createPotion(PotionType.HOLY_WATER)
    );
  }

  public final List<Potion> getTopShelf() {
    return List.copyOf(this.topShelf);
  }

  public final List<Potion> getBottomShelf() {
    return List.copyOf(this.bottomShelf);
  }

  public void drinkPotions() {
    LOGGER.info("Drinking top shelf potions");
    this.topShelf.forEach(Potion::drink);
    LOGGER.info("Drinking bottom shelf potions");
    this.bottomShelf.forEach(Potion::drink);
  }
}
