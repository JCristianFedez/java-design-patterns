package com.cristian.design.patterns.threat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cristian.design.patterns.domain.Filterer;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class SimpleThreatAwareSystem implements ThreatAwareSystem {

  private final String systemId;

  private final List<Threat> issues;

  @Override
  public String systemId() {
    return this.systemId;
  }

  @Override
  public List<? extends Threat> threats() {
    return new ArrayList<>(this.issues);
  }

  @Override
  public Filterer<? extends ThreatAwareSystem, ? extends Threat> filtered() {
    return predicate -> new SimpleThreatAwareSystem(this.systemId, filteredItems(predicate));
  }

  private List<Threat> filteredItems(final Predicate<? super Threat> predicate) {
    return this.issues.stream().filter(predicate).toList();
  }
}
