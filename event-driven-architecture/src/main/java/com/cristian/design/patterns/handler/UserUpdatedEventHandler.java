package com.cristian.design.patterns.handler;

import com.cristian.design.patterns.event.UserUpdatedEvent;
import com.cristian.design.patterns.framework.Handler;

public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {

  @Override
  public void onEvent(final UserUpdatedEvent event) {
    System.out.printf("User {} has been Updated!%n", event.getUser().getName());
  }
}
