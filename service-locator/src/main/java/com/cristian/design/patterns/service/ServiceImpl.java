package com.cristian.design.patterns.service;

import java.security.SecureRandom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ServiceImpl implements Service {

  private final String name;

  private final int id = new SecureRandom().nextInt(1000) + 1;

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void execute() {
    LOGGER.info("Service {} is now executing with id {}", getName(), getId());
  }
}
