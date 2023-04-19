package com.cristian.design.patterns;

import java.util.Collection;

import com.cristian.design.patterns.models.Royalty;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Servant {

  private final String name;

  public void feed(final Royalty royalty) {
    royalty.getFed();
  }

  public void giveWine(final Royalty royalty) {
    royalty.getDrink();
  }

  public void giveCompliments(final Royalty royalty) {
    royalty.receiveCompliments();
  }

  public boolean checkIfYouWillBeHanged(final Collection<Royalty> tableGuests) {
    return tableGuests.stream().allMatch(Royalty::getMood);
  }

  public String getName() {
    return this.name;
  }
}
