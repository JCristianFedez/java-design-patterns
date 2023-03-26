package com.cristian.design.patterns.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cristian.design.patterns.ChoreographyChapter;

/**
 * The class representing a service discovery pattern.
 */
public class ServiceDiscoveryService {

  private final Map<String, ChoreographyChapter> services = new HashMap<>();

  /**
   * find any service.
   *
   * @return any service
   */
  public ChoreographyChapter findAny() {
    return services.values().iterator().next();
  }

  public Optional<ChoreographyChapter> find(String service) {
    return Optional.ofNullable(services.getOrDefault(service, null));
  }

  public ServiceDiscoveryService discover(ChoreographyChapter chapterService) {
    services.put(chapterService.getName(), chapterService);
    return this;
  }


}
