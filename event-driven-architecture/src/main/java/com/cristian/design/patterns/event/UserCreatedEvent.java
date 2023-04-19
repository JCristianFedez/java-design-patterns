package com.cristian.design.patterns.event;

import com.cristian.design.patterns.model.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The {@link UserCreatedEvent} should be dispatched whenever a user has been created. This class can be extended to contain details about
 * the user has been created. In this example, the entire {@link User} object is passed on as data with the event.
 */
@RequiredArgsConstructor
@Getter
public class UserCreatedEvent extends AbstractEvent {

  private final User user;
}
