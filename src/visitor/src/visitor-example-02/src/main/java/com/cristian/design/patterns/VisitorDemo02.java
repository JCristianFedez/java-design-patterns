package com.cristian.design.patterns;

import com.cristian.design.patterns.commander.Commander;
import com.cristian.design.patterns.commander.CommanderVisitor;
import com.cristian.design.patterns.sergeant.Sergeant;
import com.cristian.design.patterns.sergeant.SergeantVisitor;
import com.cristian.design.patterns.soldier.Soldier;
import com.cristian.design.patterns.soldier.SoldierVisitor;

/**
 * <p>Visitor pattern defines a mechanism to apply operations on nodes in a hierarchy. New
 * operations can be added without altering the node interface.</p>
 *
 * <p>In this example there is a unit hierarchy beginning from {@link Commander}. This hierarchy is
 * traversed by visitors. {@link SoldierVisitor} applies its operation on {@link Soldier}s, {@link SergeantVisitor} on {@link Sergeant}s and
 * so on.</p>
 */
public class VisitorDemo02 {

  public static void main(String[] args) {
    final Commander commander = new Commander(
        new Sergeant(new Soldier(), new Soldier(), new Soldier()),
        new Sergeant(new Soldier(), new Soldier(), new Soldier())
    );
    commander.accept(new SoldierVisitor());
    commander.accept(new SergeantVisitor());
    commander.accept(new CommanderVisitor());
  }
}
