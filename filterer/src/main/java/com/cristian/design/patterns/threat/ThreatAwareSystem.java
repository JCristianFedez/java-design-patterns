package com.cristian.design.patterns.threat;

import java.util.List;

import com.cristian.design.patterns.domain.Filterer;

public interface ThreatAwareSystem {

  String systemId();

  List<? extends Threat> threats();

  Filterer<? extends ThreatAwareSystem, ? extends Threat> filtered();
}
