package com.cristian.design.patterns.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Task {

  private final int time;

  private boolean finished;
}
