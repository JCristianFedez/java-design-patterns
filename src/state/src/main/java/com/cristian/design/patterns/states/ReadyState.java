package com.cristian.design.patterns.states;

import com.cristian.design.patterns.ui.Player;

public class ReadyState extends State {

  public ReadyState(final Player player) {
    super(player);
  }

  @Override
  public String onLock() {
    this.player.changeState(new LockedState(this.player));
    return "Locked...";
  }

  @Override
  public String onPlay() {
    final String action = this.player.startPlayback();
    this.player.changeState(new PlayingState(this.player));
    return action;
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
