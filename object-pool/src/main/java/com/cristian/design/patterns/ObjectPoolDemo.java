package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectPoolDemo {

  private static final String CHECKED_OUT = "Checked out {}";

  private static final String CHECKED_IN = "Checked in {}";

  public static void main(String[] args) {
    new ObjectPoolDemo().run();
  }

  private void run() {
    final OliphauntPool pool = new OliphauntPool();
    LOGGER.info(pool.toString());

    final Oliphaunt oliphaunt1 = pool.checkOut();
    LOGGER.info(CHECKED_OUT, oliphaunt1);
    LOGGER.info(pool.toString());

    final Oliphaunt oliphaunt2 = pool.checkOut();
    LOGGER.info(CHECKED_OUT, oliphaunt2);

    final Oliphaunt oliphaunt3 = pool.checkOut();
    LOGGER.info(CHECKED_OUT, oliphaunt3);
    LOGGER.info(pool.toString());

    LOGGER.info(CHECKED_IN, oliphaunt1);
    pool.checkIn(oliphaunt1);
    LOGGER.info(CHECKED_IN, oliphaunt2);
    pool.checkIn(oliphaunt2);
    LOGGER.info(pool.toString());

    final Oliphaunt oliphaunt4 = pool.checkOut();
    LOGGER.info(CHECKED_OUT, oliphaunt4);

    final Oliphaunt oliphaunt5 = pool.checkOut();
    LOGGER.info(CHECKED_OUT, oliphaunt5);
    LOGGER.info(pool.toString());
  }
}
