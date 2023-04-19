package com.cristian.design.patterns.herofactory;

import com.cristian.design.patterns.beast.Beast;
import com.cristian.design.patterns.mage.Mage;
import com.cristian.design.patterns.warlord.Warlord;

public interface HeroFactory {

  Mage createMage();

  Warlord createWarlord();

  Beast createBeast();
}
