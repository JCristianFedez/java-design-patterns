package com.cristian.design.patterns.party;

import com.cristian.design.patterns.Action;
import com.cristian.design.patterns.party.member.PartyMember;

public interface Party {

  void addMember(PartyMember member);

  void act(PartyMember actor, Action action);
}
