package com.cristian.design.patterns.role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestorRole extends CustomerRole {

  private String name;

  private long amountToInvest;

  public String invest() {
    return String.format("Investor %s has invested %d dollars", this.name, this.amountToInvest);
  }
}
