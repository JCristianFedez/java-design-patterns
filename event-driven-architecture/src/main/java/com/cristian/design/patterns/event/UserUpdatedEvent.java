package com.cristian.design.patterns.event;

import com.cristian.design.patterns.model.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The {@link UserUpdatedEvent} should be dispatched whenever a user has been updated. This class can be extended to contain details about
 * the user has been updated. In this example, the entire {@link User} object is passed on as data with the event.
 */
@RequiredArgsConstructor
@Getter
public class UserUpdatedEvent extends AbstractEvent {

  private final User user;
}