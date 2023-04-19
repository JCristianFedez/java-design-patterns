package com.cristian.design.patterns;

import java.util.Optional;

interface Task {

  default void executeWith(final Callback callback) {
    execute();
    Optional.ofNullable(callback).ifPresent(Callback::call);
  }

  void execute();
}
