package com.cristian.design.patterns.services;

import com.cristian.design.patterns.user.User;
import com.cristian.design.patterns.user.UserGroup;

public class TieredFeatureToggleVersion implements Service {

  @Override
  public String welcomeMessage(final User user) {
    if (UserGroup.isPaid(user)) {
      return String.format("You're amazing {}. Thanks for paying for this awesome software", user);
    }
    return "I suppose you can use this software.";
  }

  @Override
  public boolean isEnhanced() {
    return true;
  }
}
