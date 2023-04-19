package com.cristian.design.patterns.customer;

import java.util.Arrays;
import java.util.Optional;

import com.cristian.design.patterns.role.Role;

public interface Customer {

  static Customer newCustomer() {
    return new CustomerCore();
  }

  /**
   * Create {@link Customer} with given roles.
   *
   * @param role roles
   * @return Customer
   */
  static Customer newCustomer(Role... role) {
    var customer = newCustomer();
    Arrays.stream(role).forEach(customer::addRole);
    return customer;
  }

  /**
   * Add specific role @see {@link Role}.
   *
   * @param role to add
   * @return true if the operation has been successful otherwise false
   */
  boolean addRole(Role role);

  /**
   * Check specific role @see {@link Role}.
   *
   * @param role to check
   * @return true if the role exists otherwise false
   */
  boolean hasRole(Role role);

  /**
   * Remove specific role @see {@link Role}.
   *
   * @param role to remove
   * @return true if the operation has been successful otherwise false
   */
  boolean remRole(Role role);

  /**
   * Get specific instance associated with this role @see {@link Role}.
   *
   * @param role to get
   * @param expectedRole instance class expected to get
   * @return optional with value if the instance exists and corresponds expected class
   */
  <T extends Customer> Optional<T> getRole(Role role, Class<T> expectedRole);
}
