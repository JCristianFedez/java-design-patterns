package com.cristian.design.patterns.event;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class DomainEvent implements Serializable {

  private final long sequenceId;

  private final long createdTime;

  private final String eventClassName;

  private boolean realTime = true;

  public abstract void process();
}
