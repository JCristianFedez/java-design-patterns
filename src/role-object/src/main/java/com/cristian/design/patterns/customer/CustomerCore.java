package com.cristian.design.patterns.customer;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.cristian.design.patterns.role.CustomerRole;
import com.cristian.design.patterns.role.Role;

public class CustomerCore implements Customer {

  private final Map<Role, CustomerRole> roles = new EnumMap<>(Role.class);

  @Override
  public boolean addRole(final Role role) {
    return role.instance()
        .map(instance -> {
          this.roles.put(role, instance);
          return true;
        }).orElse(false);
  }

  @Override
  public boolean hasRole(final Role role) {
    return this.roles.containsKey(role);
  }

  @Override
  public boolean remRole(final Role role) {
    return Objects.nonNull(roles.remove(role));
  }

  @Override
  public <T extends Customer> Optional<T> getRole(final Role role, final Class<T> expectedRole) {
    return Optional.ofNullable(this.roles.get(role))
        .filter(expectedRole::isInstance)
        .map(expectedRole::cast);
  }

  @Override
  public String toString() {
    final String allRoles = Arrays.toString(this.roles.keySet().toArray());
    return "Customer{roles=" + allRoles + "}";
  }
}
