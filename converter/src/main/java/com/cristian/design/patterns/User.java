package com.cristian.design.patterns;

import java.util.StringJoiner;

class User {

  private final String firstName;

  private final String lastName;

  private final boolean isActive;

  private final String userId;

  public User(final String firstName, final String lastName, final boolean isActive, final String userId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.isActive = isActive;
    this.userId = userId;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public boolean isActive() {
    return this.isActive;
  }

  public String getUserId() {
    return this.userId;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("firstName='" + firstName + "'")
        .add("lastName='" + lastName + "'")
        .add("isActive=" + isActive)
        .add("userId=" + userId)
        .toString();
  }
}
