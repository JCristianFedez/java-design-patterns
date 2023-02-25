package com.cristian.design.patterns.party;

import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.Action;
import com.cristian.design.patterns.party.member.PartyMember;

public class PartyImpl implements Party {

  private final List<PartyMember> members = new ArrayList<>();

  @Override
  public void addMember(final PartyMember member) {
    this.members.add(member);
    member.joinedParty(this);
  }

  @Override
  public void act(final PartyMember actor, final Action action) {
    this.members.stream()
        .filter(member -> !member.equals(actor))
        .forEach(member -> member.partyAction(action));
  }
}
