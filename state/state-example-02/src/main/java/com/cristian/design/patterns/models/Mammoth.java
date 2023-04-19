package com.cristian.design.patterns.models;

import com.cristian.design.patterns.states.AngryState;
import com.cristian.design.patterns.states.PeacefulState;
import com.cristian.design.patterns.states.State;

public class Mammoth {

  private State state = new PeacefulState(this);

  public void timePasses() {
    if (PeacefulState.class.equals(this.state.getClass())) {
      changeStateTo(new AngryState(this));
    } else {
      changeStateTo(new PeacefulState(this));
    }
  }

  private void changeStateTo(final State state) {
    this.state = state;
    this.state.onEnterState();
  }

  public void observe() {
    this.state.observe();
  }

  @Override
  public String toString() {
    return Mammoth.class.getSimpleName();
  }
}
