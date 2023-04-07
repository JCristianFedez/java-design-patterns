package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cristian.design.patterns.db.WeaponDatabase;
import com.cristian.design.patterns.models.UnitActions;
import com.cristian.design.patterns.models.Weapon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArmsDealer implements UnitOfWork<Weapon> {

  private final Map<UnitActions, List<Weapon>> context = new HashMap<>();
  private final WeaponDatabase weaponDatabase = new WeaponDatabase();

  @Override
  public void registerNow(final Weapon entity) {
    LOGGER.info("Registering {} for insert in context.", entity.name());
    register(entity, UnitActions.INSERT);
  }

  @Override
  public void registerModified(final Weapon entity) {
    LOGGER.info("Registering {} for modify in context.", entity.name());
    register(entity, UnitActions.MODIFY);
  }

  @Override
  public void registerDeleted(final Weapon entity) {
    LOGGER.info("Registering {} for delete in context.", entity.name());
    register(entity, UnitActions.DELETE);
  }

  @Override
  public void commit() {
    if (this.context.isEmpty()) {
      return;
    }
    LOGGER.info("Commit started");
    if (this.context.containsKey(UnitActions.INSERT)) {
      commitInsert();
    }

    if (this.context.containsKey(UnitActions.MODIFY)) {
      commitModify();
    }
    if (this.context.containsKey(UnitActions.DELETE)) {
      commitDelete();
    }
    LOGGER.info("Commit finished.");
  }

  private void commitInsert() {
    for (Weapon weapon : this.context.get(UnitActions.INSERT)) {
      LOGGER.info("Inserting a new weapon {} to sales rack.", weapon.name());
      this.weaponDatabase.insert(weapon);
    }
  }

  private void commitModify() {
    for (Weapon weapon : this.context.get(UnitActions.MODIFY)) {
      LOGGER.info("Scheduling {} for modification work.", weapon.name());
      this.weaponDatabase.modify(weapon);
    }
  }

  private void commitDelete() {
    for (Weapon weapon : this.context.get(UnitActions.DELETE)) {
      LOGGER.info("Scrapping {}.", weapon.name());
      this.weaponDatabase.delete(weapon);
    }
  }
  private void register(final Weapon weapon, final UnitActions operation) {
    List<Weapon> weaponsToOperate = this.context.get(operation);
    if (weaponsToOperate == null) {
      weaponsToOperate = new ArrayList<>();
    }
    weaponsToOperate.add(weapon);
    this.context.put(operation, weaponsToOperate);
  }
}
