package com.cristian.design.patterns.map;

import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.person.Person;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * This class stores the map into which we will be caching records after loading them from a DataBase. Stores the records as a Hash Map with
 * the personNationalIDs as keys.
 */
@Slf4j
@Getter
public class IdentityMap {

  private final Map<Integer, Person> cache = new HashMap<>();

  public void addPerson(final Person person) {
    if (this.cache.putIfAbsent(person.getId(), person) != null) {
      LOGGER.info("Key already in Map");
    }
  }

  public Person findPerson(final int id) {
    final Person person = this.cache.get(id);
    if (person == null) {
      LOGGER.info("ID {} not in Map.", id);
      return null;
    }
    LOGGER.info(person.toString());
    return person;
  }

  public int size() {
    return this.cache.size();
  }
}
