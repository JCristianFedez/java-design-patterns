package com.cristian.design.patterns.person.db;

import com.cristian.design.patterns.person.Person;

public interface PersonDbSimulator {

  Person find(int id);

  void insert(Person person);

  void update(Person person);

  void delete(int id);
}
