package com.cristian.design.patterns.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private String name;

  private String contactNumber;

  private String address;

  private String depositNumber;

  private String orderItem;

}