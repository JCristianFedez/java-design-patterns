package com.cristian.design.patterns.party.member;

import com.cristian.design.patterns.Action;
import com.cristian.design.patterns.party.Party;

public interface PartyMember {

  void joinedParty(Party party);

  void partyAction(Action action);

  void act(Action action);
}
