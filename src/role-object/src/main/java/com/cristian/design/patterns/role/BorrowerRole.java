package com.cristian.design.patterns.role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BorrowerRole extends CustomerRole {

  private String name;

  public String borrow() {
    return String.format("Borrower %s wants to get some money.", this.name);
  }
}
