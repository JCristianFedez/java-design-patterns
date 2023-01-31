package com.cristian.design.patterns;

import java.util.StringJoiner;

class UserDto {

  private final String firstName;

  private final String lastName;

  private final boolean isActive;

  private final String email;

  public UserDto(final String firstName, final String lastName, final boolean isActive, final String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.isActive = isActive;
    this.email = email;
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

  public String getEmail() {
    return this.email;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("firstName='" + firstName + "'")
        .add("lastName='" + lastName + "'")
        .add("isActive=" + isActive)
        .add("email=" + email)
        .toString();
  }
}
