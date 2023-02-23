package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MarkerDemo {

  public static void main(String[] args) {
    new MarkerDemo().run();
  }

  private void run() {
    tryToEnter(new Guard(1));
    tryToEnter(new Thief(1));
  }

  private static void tryToEnter(final Entity entity) {
    if (Permission.class.isAssignableFrom(entity.getClass())) {
      LOGGER.info("entity {} You have permission to enter", entity.getId());
      ((Guard) entity).openTheDoor();
    } else {
      LOGGER.info("entity {} You haven't permission to enter, please leave this area", entity.getId());
    }
  }
}
