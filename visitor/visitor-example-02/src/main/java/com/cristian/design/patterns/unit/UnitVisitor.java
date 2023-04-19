package com.cristian.design.patterns.unit;

import com.cristian.design.patterns.commander.Commander;
import com.cristian.design.patterns.sergeant.Sergeant;
import com.cristian.design.patterns.soldier.Soldier;

public interface UnitVisitor {

  void visit(Soldier soldier);

  void visit(Sergeant sergeant);

  void visit(Commander commander);
}
