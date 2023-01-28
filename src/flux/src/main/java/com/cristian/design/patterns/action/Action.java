package com.cristian.design.patterns.action;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Action {

  private final ActionType type;
}
