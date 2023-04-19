package com.cristian.design.patterns;

import com.cristian.design.patterns.wizardtower.IvoryTower;
import com.cristian.design.patterns.wizardtower.WizardTower;
import com.cristian.design.patterns.wizardtower.WizardTowerProxy;

public class ProxyDemo02 {

  public static void main(String[] args) {
    final WizardTower proxy = new WizardTowerProxy(new IvoryTower());
    proxy.enter(new Wizard("Red wizard"));
    proxy.enter(new Wizard("White wizard"));
    proxy.enter(new Wizard("Black wizard"));
    proxy.enter(new Wizard("Green wizard"));
    proxy.enter(new Wizard("Brown wizard"));
  }
}
