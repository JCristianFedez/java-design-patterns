package com.cristian.design.patterns.states;

import com.cristian.design.patterns.ui.Player;

public class LockedState extends State {

  LockedState(final Player player) {
    super(player);
    this.player.setPlaying(false);
  }

  @Override
  public String onLock() {
    if (this.player.isPlaying()) {
      this.player.changeState(new ReadyState(this.player));
      return "Stop playing";
    } else {
      return "Locked...";
    }
  }

  @Override
  public String onPlay() {
    this.player.changeState(new ReadyState(this.player));
    return "Ready";
  }

  @Override
  public String onNext() {
    return "Locked...";
  }

  @Override
  public String onPrevious() {
    return "Locked...";
  }
}
