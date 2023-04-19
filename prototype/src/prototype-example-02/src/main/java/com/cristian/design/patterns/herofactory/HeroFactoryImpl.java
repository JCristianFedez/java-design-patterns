package com.cristian.design.patterns.herofactory;

import com.cristian.design.patterns.beast.Beast;
import com.cristian.design.patterns.mage.Mage;
import com.cristian.design.patterns.warlord.Warlord;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeroFactoryImpl implements HeroFactory {

  private final Mage mage;

  private final Warlord warlord;

  private final Beast beast;

  @Override
  public Mage createMage() {
    return this.mage.copy();
  }

  @Override
  public Warlord createWarlord() {
    return this.warlord.copy();
  }

  @Override
  public Beast createBeast() {
    return this.beast.copy();
  }
}
