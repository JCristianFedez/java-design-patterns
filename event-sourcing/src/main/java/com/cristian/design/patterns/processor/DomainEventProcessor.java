package com.cristian.design.patterns.processor;

import com.cristian.design.patterns.event.DomainEvent;

public class DomainEventProcessor {

  private final JsonFileJournal processJournal = new JsonFileJournal();

  public void process(final DomainEvent domainEvent) {
    domainEvent.process();
    this.processJournal.write(domainEvent);
  }

  public void reset() {
    this.processJournal.reset();
  }

  public void recover() {
    DomainEvent domainEvent;
    while ((domainEvent = this.processJournal.readNext()) != null) {
      domainEvent.process();
    }
  }
}
