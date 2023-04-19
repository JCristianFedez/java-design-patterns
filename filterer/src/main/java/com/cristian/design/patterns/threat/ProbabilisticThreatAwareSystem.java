package com.cristian.design.patterns.threat;

import java.util.List;

import com.cristian.design.patterns.domain.Filterer;

public interface ProbabilisticThreatAwareSystem extends ThreatAwareSystem {

  @Override
  List<? extends ProbableThreat> threats();

  @Override
  Filterer<? extends ProbabilisticThreatAwareSystem, ? extends ProbableThreat> filtered();
}
