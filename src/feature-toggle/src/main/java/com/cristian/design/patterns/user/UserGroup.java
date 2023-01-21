package com.cristian.design.patterns.user;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {

  private static final List<User> FREE_GROUP = new ArrayList<>();

  private static final List<User> PAID_GROUP = new ArrayList<>();

  private UserGroup() {
  }

  public static void addUserToFreeGroup(final User user) {
    if (PAID_GROUP.contains(user)) {
      throw new IllegalArgumentException("User already member for paid group.");
    }
    if (!FREE_GROUP.contains(user)) {
      FREE_GROUP.add(user);
    }
  }

  public static void addUserToPaidGroup(final User user) {
    if (FREE_GROUP.contains(user)) {
      throw new IllegalArgumentException("User already member for free group.");
    }
    if (!PAID_GROUP.contains(user)) {
      PAID_GROUP.add(user);
    }
  }

  public static boolean isPaid(final User user) {
    return PAID_GROUP.contains(user);
  }
}
