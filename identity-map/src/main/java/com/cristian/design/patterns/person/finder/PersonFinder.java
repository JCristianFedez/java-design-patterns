package com.cristian.design.patterns.person.finder;

import java.util.function.Supplier;

import com.cristian.design.patterns.map.IdentityMap;
import com.cristian.design.patterns.person.Person;
import com.cristian.design.patterns.person.db.PersonDbSimulator;
import com.cristian.design.patterns.person.db.PersonDbSimulatorImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class PersonFinder {

  private final IdentityMap identityMap = new IdentityMap();

  private PersonDbSimulator db = new PersonDbSimulatorImpl();

  public Person findPerson(final int id) {
    final Person person = OptionalSupplier.of(() -> findOnCache(id))
        .orElseGet(() -> findOnDb(id))
        .get();

    if (person == null) {
      LOGGER.info("Person with id {} does not exists", id);
    }

    return person;
  }

  private Person findOnDb(final int id) {
    final Person person = this.db.find(id);
    if (person != null) {
      this.identityMap.addPerson(person);
      LOGGER.info("Person {} found in DB.", person);
      return person;
    }
    return null;
  }

  private Person findOnCache(final int id) {
    final Person person = this.identityMap.findPerson(id);

    if (person != null) {
      LOGGER.info("Person {} found in the Map", person);
      return person;
    }
    return null;
  }

  @FunctionalInterface
  private interface OptionalSupplier<T> {

    T get();

    default OptionalSupplier<T> orElseGet(final OptionalSupplier<T> supplier) {
      T value = get();
      return value != null ? () -> value : supplier;
    }

    static <T> OptionalSupplier<T> of(final Supplier<T> supplier) {
      return supplier::get;
    }
  }
}
