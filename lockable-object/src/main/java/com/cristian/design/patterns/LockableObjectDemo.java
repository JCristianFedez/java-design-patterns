package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.cristian.design.patterns.domain.Creature;
import com.cristian.design.patterns.domain.Elf;
import com.cristian.design.patterns.domain.Feind;
import com.cristian.design.patterns.domain.Human;
import com.cristian.design.patterns.domain.Orc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LockableObjectDemo {

  private static final int WAIT_TIME = 3;

  private static final int WORKERS = 2;

  private static final int MULTIPLICATION_FACTOR = 3;

  public static void main(String[] args) {
    new LockableObjectDemo().run();
  }

  private void run() {
    final List<Creature> creatures = new ArrayList<>();
    for (int i = 0; i <= WORKERS; i++) {
      creatures.add(new Elf(String.format("Elf %s", i)));
      creatures.add(new Orc(String.format("Orc %s", i)));
      creatures.add(new Human(String.format("Human %s", i)));
    }

    final int totalFiends = WORKERS * MULTIPLICATION_FACTOR;
    final ExecutorService service = Executors.newFixedThreadPool(totalFiends);
    final SwordOfAragorn sword = new SwordOfAragorn();
    for (int i = 0; i < totalFiends; i++) {
      service.submit(new Feind(creatures.get(i), sword));
      lag();
      service.submit(new Feind(creatures.get(i + 1), sword));
      lag();
      service.submit(new Feind(creatures.get(i + 2), sword));
    }

    try {
      if (!service.awaitTermination(WAIT_TIME, TimeUnit.SECONDS)) {
        LOGGER.info("The master of the sword is now {}", sword.getLocker().getName());
      }
    } catch (InterruptedException e) {
      LOGGER.error(e.getMessage());
      Thread.currentThread().interrupt();
    } finally {
      service.shutdown();
    }
  }

  private static void lag() {
    try {
      Thread.sleep(200L);
    } catch (InterruptedException ignore) {
      Thread.currentThread().interrupt();
    }
  }
}
