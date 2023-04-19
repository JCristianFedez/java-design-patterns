package com.cristian.design.patterns.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cristian.design.patterns.chapter.OrchestrationChapter;

public class ServiceDiscoveryService {

  private final Map<String, OrchestrationChapter<?>> services = new HashMap<>();

  public Optional<OrchestrationChapter<?>> find(final String service) {
    final OrchestrationChapter<?> orDefault = this.services.getOrDefault(service, null);
    return Optional.ofNullable(orDefault);
  }

  public ServiceDiscoveryService discover(final OrchestrationChapter<?> orchestrationChapterService) {
    this.services.put(orchestrationChapterService.getName(), orchestrationChapterService);
    return this;
  }
}
