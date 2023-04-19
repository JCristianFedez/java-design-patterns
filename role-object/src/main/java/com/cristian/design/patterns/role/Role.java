package com.cristian.design.patterns.role;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public enum Role {
  BORROWER(BorrowerRole.class),
  INVESTOR(InvestorRole.class);

  private final Class<? extends CustomerRole> typeCst;

  @SuppressWarnings("unchecked")
  public <T extends CustomerRole> Optional<T> instance() {
    try {
      final Constructor<? extends CustomerRole> constructor = this.typeCst.getDeclaredConstructor();
      return (Optional<T>) Optional.of(constructor.newInstance());
    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
      LOGGER.error(e.getMessage());
    }

    return Optional.empty();
  }
}
