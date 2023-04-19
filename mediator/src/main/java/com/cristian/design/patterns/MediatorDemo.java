package com.cristian.design.patterns;

import com.cristian.design.patterns.party.Party;
import com.cristian.design.patterns.party.PartyImpl;
import com.cristian.design.patterns.roles.Hobbit;
import com.cristian.design.patterns.roles.Hunter;
import com.cristian.design.patterns.roles.Rogue;
import com.cristian.design.patterns.roles.Wizard;

public class MediatorDemo {

  public static void main(String[] args) {
    new MediatorDemo().run();
  }

  private void run() {
    final Party party = new PartyImpl();

    final Hobbit hobbit = new Hobbit();
    party.addMember(hobbit);

    final Wizard wizard = new Wizard();
    party.addMember(wizard);

    final Rogue rogue = new Rogue();
    party.addMember(rogue);

    final Hunter hunter = new Hunter();
    party.addMember(hunter);

    hobbit.act(Action.ENEMY);
    wizard.act(Action.TALE);
    rogue.act(Action.GOLD);
    hunter.act(Action.HUNT);
  }
}
