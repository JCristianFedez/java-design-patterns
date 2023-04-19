package com.cristian.design.patterns;

import com.cristian.design.patterns.service.ServiceLocator;

public class ServiceLocatorDemo {
  private static final String JNDI_SERVICE_A = "jndi/serviceA";
  private static final String JNDI_SERVICE_B = "jndi/serviceB";

  public static void main(String[] args) {
    ServiceLocator.getService(JNDI_SERVICE_A).execute();
    ServiceLocator.getService(JNDI_SERVICE_B).execute();
    ServiceLocator.getService(JNDI_SERVICE_A).execute();
    ServiceLocator.getService(JNDI_SERVICE_A).execute();
  }
}
