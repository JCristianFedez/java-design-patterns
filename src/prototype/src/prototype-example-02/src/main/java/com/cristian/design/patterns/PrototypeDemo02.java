package com.cristian.design.patterns;

import com.cristian.design.patterns.beast.Beast;
import com.cristian.design.patterns.beast.ElfBeast;
import com.cristian.design.patterns.beast.OrcBeast;
import com.cristian.design.patterns.herofactory.HeroFactory;
import com.cristian.design.patterns.herofactory.HeroFactoryImpl;
import com.cristian.design.patterns.mage.ElfMage;
import com.cristian.design.patterns.mage.Mage;
import com.cristian.design.patterns.mage.OrcMage;
import com.cristian.design.patterns.warlord.ElfWarlord;
import com.cristian.design.patterns.warlord.OrcWarlord;
import com.cristian.design.patterns.warlord.Warlord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeDemo02 {

  public static void main(String[] args) {
    final HeroFactory elfFactory = new HeroFactoryImpl(
        new ElfMage("Cooking"),
        new ElfWarlord("Cleaning"),
        new ElfBeast("Protecting")
    );

    buildEntities(elfFactory);

    final HeroFactory orcFactory = new HeroFactoryImpl(
        new OrcMage("Axe"),
        new OrcWarlord("Sword"),
        new OrcBeast("Laser")
    );

    buildEntities(orcFactory);
  }

  private static void buildEntities(final HeroFactory factory) {
    final Mage mage = factory.createMage();
    final Warlord warlord = factory.createWarlord();
    final Beast beast = factory.createBeast();

    LOGGER.info(mage.toString());
    LOGGER.info(warlord.toString());
    LOGGER.info(beast.toString());
  }
}
