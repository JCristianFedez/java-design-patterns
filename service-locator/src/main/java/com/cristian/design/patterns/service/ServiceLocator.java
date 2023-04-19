package com.cristian.design.patterns.service;

import com.cristian.design.patterns.InitContext;

public class ServiceLocator {

  private static final ServiceCache serviceCache = new ServiceCache();

  public static Service getService(final String name) {
    final Service service = serviceCache.getService(name);
    if (service != null) {
      return service;
    }
    final InitContext context = new InitContext();
    final Service serviceByContext = (Service) context.lookup(name);
    if (serviceByContext != null) { // Only cache a service if it actually exists
      serviceCache.addService(serviceByContext);
    }
    return serviceByContext;
  }
}
