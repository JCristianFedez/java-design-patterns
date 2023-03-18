package com.cristian.design.patterns;

import com.cristian.design.patterns.customer.Customer;
import com.cristian.design.patterns.role.BorrowerRole;
import com.cristian.design.patterns.role.InvestorRole;
import com.cristian.design.patterns.role.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoleObjectDemo {

  public static void main(String[] args) {
    final Customer customer = Customer.newCustomer(Role.BORROWER, Role.INVESTOR);

    LOGGER.info("The new customer created : {}", customer);

    final boolean hasBorrowerRole = customer.hasRole(Role.BORROWER);
    LOGGER.info("Customer has a borrowed role - {}", hasBorrowerRole);
    final boolean hasInvestorRole = customer.hasRole(Role.INVESTOR);
    LOGGER.info("Customer has an investor role - {}", hasInvestorRole);

    customer.getRole(Role.INVESTOR, InvestorRole.class)
        .ifPresent(inv -> {
          inv.setAmountToInvest(1000);
          inv.setName("Billy");
        });
    customer.getRole(Role.BORROWER, BorrowerRole.class)
        .ifPresent(inv -> inv.setName("Johny"));

    customer.getRole(Role.INVESTOR, InvestorRole.class)
        .map(InvestorRole::invest)
        .ifPresent(LOGGER::info);

    customer.getRole(Role.BORROWER, BorrowerRole.class)
        .map(BorrowerRole::borrow)
        .ifPresent(LOGGER::info);
  }
}
