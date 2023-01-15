package com.cristian.design.patterns;

import java.util.Optional;
import java.util.function.Function;

import com.cristian.design.patterns.abstractextensions.CommanderExtension;
import com.cristian.design.patterns.abstractextensions.SergeantExtension;
import com.cristian.design.patterns.abstractextensions.SoldierExtension;
import com.cristian.design.patterns.units.CommanderUnit;
import com.cristian.design.patterns.units.SergeantUnit;
import com.cristian.design.patterns.units.SoldierUnit;
import com.cristian.design.patterns.units.Unit;

public class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    checkSoldier();
    checkSergeant();
    checkCommander();
  }

  private void checkCommander() {
    System.out.println("\n\n[ COMMANDER ]");
    final CommanderUnit commander = new CommanderUnit("CommanderUnit1");
    checkExtensionForUnit(commander);
  }

  private void checkSergeant() {
    System.out.println("\n\n[ SERGEANT ]");
    final SergeantUnit sergeant = new SergeantUnit("SergeantUnit1");
    checkExtensionForUnit(sergeant);
  }

  private void checkSoldier() {
    System.out.println("\n\n[ SOLDIER ]");
    final SoldierUnit soldier = new SoldierUnit("SoldierUnit1");
    checkExtensionForUnit(soldier);
  }

  private void checkExtensionForUnit(final Unit unit) {
    final String name = unit.getName();
    final Function<String, Runnable> func = extension -> () -> System.out.printf("%s without %s%n", name, extension);

    Optional.ofNullable(unit.getUnitExtension(SoldierExtension.class.getSimpleName()))
        .map(SoldierExtension.class::cast)
        .ifPresentOrElse(SoldierExtension::soldierReady, func.apply(SoldierExtension.class.getSimpleName()));

    Optional.ofNullable(unit.getUnitExtension(SergeantExtension.class.getSimpleName()))
        .map(SergeantExtension.class::cast)
        .ifPresentOrElse(SergeantExtension::sergeantReady, func.apply(SergeantExtension.class.getSimpleName()));

    Optional.ofNullable(unit.getUnitExtension(CommanderExtension.class.getSimpleName()))
        .map(CommanderExtension.class::cast)
        .ifPresentOrElse(CommanderExtension::commanderReady, func.apply(CommanderExtension.class.getSimpleName()));
  }
}
