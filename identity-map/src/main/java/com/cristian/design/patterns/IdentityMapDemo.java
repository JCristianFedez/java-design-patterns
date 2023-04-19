package com.cristian.design.patterns;

import com.cristian.design.patterns.person.Person;
import com.cristian.design.patterns.person.db.PersonDbSimulator;
import com.cristian.design.patterns.person.db.PersonDbSimulatorImpl;
import com.cristian.design.patterns.person.finder.PersonFinder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdentityMapDemo {

  public static void main(String[] args) {
    new IdentityMapDemo().run();
  }

  private void run() {
    // Dummy Persons
    Person person1 = new Person(1, "John", 27304159);
    Person person2 = new Person(2, "Thomas", 42273631);
    Person person3 = new Person(3, "Arthur", 27489171);
    Person person4 = new Person(4, "Finn", 20499078);
    Person person5 = new Person(5, "Michael", 40599078);

    // Init database
    PersonDbSimulator db = new PersonDbSimulatorImpl();
    db.insert(person1);
    db.insert(person2);
    db.insert(person3);
    db.insert(person4);
    db.insert(person5);

    // Init a personFinder
    PersonFinder finder = new PersonFinder();
    finder.setDb(db);

    // Find persons in DataBase not the map.
    LOGGER.info(finder.findPerson(2).toString());
    LOGGER.info(finder.findPerson(4).toString());
    LOGGER.info(finder.findPerson(5).toString());
    // Find the person in the map.
    LOGGER.info(finder.findPerson(2).toString());
  }
}
