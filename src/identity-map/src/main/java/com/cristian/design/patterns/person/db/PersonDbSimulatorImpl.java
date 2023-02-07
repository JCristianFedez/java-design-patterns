package com.cristian.design.patterns.person.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cristian.design.patterns.exception.IdNotFoundException;
import com.cristian.design.patterns.person.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * This is a sample database implementation. The database is in the form of an arraylist which stores records of different persons. The ID
 * acts as the primary key for a record.
 */
@Slf4j
public class PersonDbSimulatorImpl implements PersonDbSimulator {

  private static final String NOT_IN_DATA_BASE = " not in DataBase";

  private static final String ID_STR = "ID : ";

  //This simulates a table in the database. To extend logic to multiple tables just add more lists to the implementation.
  private final List<Person> persons = new ArrayList<>();

  @Override
  public Person find(final int id) {
    final Person personFound = findPersonOrElseThrowException(id);
    LOGGER.info("Found record {}", personFound.toString());
    return personFound;
  }

  @Override
  public void insert(final Person person) {
    if (findPersonById(person.getId()).isPresent()) {
      LOGGER.info("Record with id {} already exists", person.getId());
    }
    this.persons.add(person);
  }

  @Override
  public void update(final Person person) {
    final Person personToUpdate = findPersonOrElseThrowException(person.getId());
    personToUpdate.setName(person.getName());
    personToUpdate.setPhone(person.getPhone());
    LOGGER.info("Record {} updated successfully", person);
  }

  @Override
  public void delete(final int id) {
    final Person personToDelete = findPersonOrElseThrowException(id);
    this.persons.remove(personToDelete);
    LOGGER.info("Record {} deleted successfully", personToDelete);
  }

  private Optional<Person> findPersonById(final int person) {
    return this.persons.stream()
        .filter(per -> per.getId() == person)
        .findFirst();
  }

  public int size() {
    return this.persons.size();
  }

  private Person findPersonOrElseThrowException(final int id) {
    return findPersonById(id).orElseThrow(() -> new IdNotFoundException(ID_STR + id + NOT_IN_DATA_BASE));
  }
}
