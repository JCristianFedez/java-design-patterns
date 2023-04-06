package com.cristian.design.patterns.models;

import java.util.ArrayList;
import java.util.List;

public class CharacterStepBuilder {

  public static NameStep newBuilder()  {
    return new CharacterSteps();
  }

  private CharacterStepBuilder() {
  }

  public interface NameStep {

    ClassStep name(String name);
  }

  public interface ClassStep {

    WeaponStep fighterClass(String fighterClass);

    SpellStep wizardClass(String wizardClass);
  }

  public interface WeaponStep {

    AbilityStep withWeapon(String weapon);

    BuildStep noWeapon();
  }

  public interface SpellStep {

    AbilityStep withSpell(String spell);

    BuildStep noSpell();
  }

  public interface AbilityStep {

    AbilityStep withAbility(String ability);

    BuildStep noMoreAbilities();

    BuildStep noAbilities();

  }

  /**
   * This is the final step in charge of building the {@link Character}- Validation should be here.
   */
  public interface BuildStep {

    Character build();
  }

  private static class CharacterSteps implements NameStep, ClassStep, WeaponStep, SpellStep, AbilityStep, BuildStep {

    private final List<String> abilities = new ArrayList<>();

    private String name;

    private String fighterClass;

    private String wizardClass;

    private String weapon;

    private String spell;

    @Override
    public ClassStep name(final String name) {
      this.name = name;
      return this;
    }

    @Override
    public WeaponStep fighterClass(final String fighterClass) {
      this.fighterClass = fighterClass;
      return this;
    }

    @Override
    public SpellStep wizardClass(final String wizardClass) {
      this.wizardClass = wizardClass;
      return this;
    }

    @Override
    public AbilityStep withWeapon(final String weapon) {
      this.weapon = weapon;
      return this;
    }

    @Override
    public BuildStep noWeapon() {
      return this;
    }

    @Override
    public AbilityStep withSpell(final String spell) {
      this.spell = spell;
      return this;
    }

    @Override
    public BuildStep noSpell() {
      return this;
    }

    @Override
    public AbilityStep withAbility(final String ability) {
      this.abilities.add(ability);
      return this;
    }

    @Override
    public BuildStep noMoreAbilities() {
      return this;
    }

    @Override
    public BuildStep noAbilities() {
      return this;
    }

    @Override
    public Character build() {
      final Character character = new Character(this.name);
      if (this.fighterClass != null) {
        character.setFighterClass(fighterClass);
      } else {
        character.setWizardClass(this.wizardClass);
      }

      if (this.weapon != null) {
        character.setWeapon(this.weapon);
      } else {
        character.setSpell(this.spell);
      }

      if (!this.abilities.isEmpty()) {
        character.setAbilities(this.abilities);
      }
      return character;
    }
  }
}
