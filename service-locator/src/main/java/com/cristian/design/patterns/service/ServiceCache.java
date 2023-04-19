package com.cristian.design.patterns.service;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceCache {

  private final Map<String, Service> cache = new HashMap<>();

  public Service getService(final String name) {
    if (this.cache.containsKey(name)) {
      final Service service = this.cache.get(name);
      LOGGER.info("(cache call) Fetched service {}({}) from cache... !", service.getName(), service.getId());
      return service;
    }
    return null;
  }

  public void addService(final Service newService) {
    this.cache.put(newService.getName(), newService);
  }
}
