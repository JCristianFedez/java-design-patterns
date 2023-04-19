package com.cristian.design.patterns.db;

import com.cristian.design.patterns.models.Weapon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeaponDatabase {

  public void insert(final Weapon weapon) {
    LOGGER.info("Insert {} in db", weapon);
  }

  public void modify(final Weapon weapon) {
    LOGGER.info("Modify {} in db", weapon);
  }

  public void delete(final Weapon weapon) {
    LOGGER.info("Delete {} in db", weapon);
  }
}
