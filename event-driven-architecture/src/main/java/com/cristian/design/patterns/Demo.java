package com.cristian.design.patterns;

import com.cristian.design.patterns.event.UserCreatedEvent;
import com.cristian.design.patterns.event.UserUpdatedEvent;
import com.cristian.design.patterns.framework.EventDispatcher;
import com.cristian.design.patterns.handler.UserCreatedEventHandler;
import com.cristian.design.patterns.handler.UserUpdatedEventHandler;
import com.cristian.design.patterns.model.User;

/**
 * An event-driven architecture (EDA) is a framework that orchestrates behavior around the production, detection and consumption of events
 * as well as the responses they evoke. An event is any identifiable occurrence that has significance for system hardware or software.
 *
 * <p>The example below uses an {@link EventDispatcher} to link/register {@link com.cristian.design.patterns.framework.Event} objects to
 * their respective handlers once an {@link com.cristian.design.patterns.framework.Event} is dispatched, it's respective handler is invoked
 * and the {@link com.cristian.design.patterns.framework.Event} is handled accordingly.
 */
public class Demo {

  /**
   * Once the {@link EventDispatcher} is initialised, handlers related to specific events have to be made known to the dispatcher by
   * registering them. In this case the {@link UserCreatedEvent} is bound to the UserCreatedEventHandler, whilst the
   * {@link UserUpdatedEvent} is bound to the {@link UserUpdatedEventHandler}. The dispatcher can now be called to dispatch specific events.
   * When a user is saved, the {@link UserCreatedEvent} can be dispatched. On the other hand, when a user is updated,
   * {@link UserUpdatedEvent} can be dispatched.
   */
  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final EventDispatcher eventDispatcher = new EventDispatcher();
    eventDispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
    eventDispatcher.registerHandler(UserUpdatedEvent.class, new UserUpdatedEventHandler());

    final User user = new User("Cristian");
    eventDispatcher.dispatch(new UserCreatedEvent(user));
    eventDispatcher.dispatch(new UserUpdatedEvent(user));
  }
}
