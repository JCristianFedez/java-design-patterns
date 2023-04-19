package com.cristian.design.patterns.handler;

import com.cristian.design.patterns.event.UserCreatedEvent;
import com.cristian.design.patterns.framework.Handler;

public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

  @Override
  public void onEvent(UserCreatedEvent event) {
    System.out.printf("User {} has been Created!%n", event.getUser().getName());
  }

}