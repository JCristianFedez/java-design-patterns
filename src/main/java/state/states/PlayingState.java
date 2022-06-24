package state.states;

import state.ui.Player;

public class PlayingState extends State {

  PlayingState(final Player player) {
    super(player);
  }

  @Override
  public String onLock() {
    this.player.changeState(new LockedState(this.player));
    this.player.setCurrentTrackAfterStop();
    return "Stop playing";
  }

  @Override
  public String onPlay() {
    this.player.changeState(new ReadyState(this.player));
    return "Paused...";
  }

  @Override
  public String onNext() {
    return this.player.nextTrack();
  }

  @Override
  public String onPrevious() {
    return this.player.previousTrack();
  }
}
