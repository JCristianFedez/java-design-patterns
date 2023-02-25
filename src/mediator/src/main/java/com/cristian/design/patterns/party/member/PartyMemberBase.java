package com.cristian.design.patterns.party.member;

import com.cristian.design.patterns.Action;
import com.cristian.design.patterns.party.Party;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class PartyMemberBase implements PartyMember {

  protected Party party;

  @Override
  public void joinedParty(final Party party) {
    LOGGER.info("{} joins the party", this);
    this.party = party;
  }

  @Override
  public void partyAction(final Action action) {
    LOGGER.info("{} {}", this, action.getDescription());
  }

  @Override
  public void act(final Action action) {
    if (this.party != null) {
      LOGGER.info("{} {}", this, action);
      this.party.act(this, action);
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
