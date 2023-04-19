package com.cristian.design.patterns;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonadDemo {

  public static void main(String[] args) {
    new MonadDemo().run();
  }

  private void run() {
    final User user = new User("User", 24, Sex.FEMALE, "Foobar.com");
    LOGGER.info(Validator.of(user).validate(User::name, Objects::nonNull, "name is null")
        .validate(User::name, name -> !name.isEmpty(), "name is empty")
        .validate(User::email, email -> !email.contains("@"), "email doesn't contains '@'")
        .validate(User::age, age -> age > 20 && age < 30, "age isn't between...")
        .get()
        .toString());
  }
}
