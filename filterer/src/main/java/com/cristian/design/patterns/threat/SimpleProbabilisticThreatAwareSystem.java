package com.cristian.design.patterns.threat;

import java.util.List;
import java.util.function.Predicate;

import com.cristian.design.patterns.domain.Filterer;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class SimpleProbabilisticThreatAwareSystem implements ProbabilisticThreatAwareSystem {

  private final String systemId;

  private final List<ProbableThreat> threats;

  @Override
  public String systemId() {
    return this.systemId;
  }

  @Override
  public List<? extends ProbableThreat> threats() {
    return this.threats;
  }

  @Override
  public Filterer<? extends ProbabilisticThreatAwareSystem, ? extends ProbableThreat> filtered() {
    return predicate -> new SimpleProbabilisticThreatAwareSystem(this.systemId, filteredItems(predicate));
  }

  private List<ProbableThreat> filteredItems(final Predicate<? super ProbableThreat> predicate) {
    return this.threats.stream().filter(predicate).toList();
  }
}
