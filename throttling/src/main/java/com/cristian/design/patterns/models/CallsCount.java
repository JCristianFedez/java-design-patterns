package com.cristian.design.patterns.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CallsCount {

  private final Map<String, AtomicLong> tenantCallsCount = new ConcurrentHashMap<>();

  public void addTenant(final String tenantName) {
    this.tenantCallsCount.putIfAbsent(tenantName, new AtomicLong(0));
  }

  public void incrementCount(final String tenantName) {
    this.tenantCallsCount.get(tenantName).incrementAndGet();
  }

  public long getCount(final String tenantName) {
    return this.tenantCallsCount.get(tenantName).get();
  }

  public void reset() {
    this.tenantCallsCount.replaceAll((k, v) -> new AtomicLong(0));
    LOGGER.info("Reset counters");
  }
}
