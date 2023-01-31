package com.cristian.design.patterns.ui;

import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.states.ReadyState;
import com.cristian.design.patterns.states.State;

public class Player {

  private final List<String> playList = new ArrayList<>();

  private State state;

  private boolean playing = false;

  private int currentTrack = 0;

  public Player() {
    this.state = new ReadyState(this);
    for (int i = 0; i < 12; i++) {
      this.playList.add(String.format("Track {}", i));
    }
  }

  public void changeState(final State state) {
    this.state = state;
  }

  public State getState() {
    return this.state;
  }

  public boolean isPlaying() {
    return this.playing;
  }

  public void setPlaying(final boolean playing) {
    this.playing = playing;
  }

  public String startPlayback() {
    return String.format("Playing {}", this.currentPlayList());
  }

  public String nextTrack() {
    this.modifyCurrentTrack(true);
    return this.startPlayback();
  }

  public String previousTrack() {
    this.modifyCurrentTrack(false);
    return this.startPlayback();
  }

  public void setCurrentTrackAfterStop() {
    this.currentTrack = 0;
  }

  private void modifyCurrentTrack(final boolean increase) {
    this.currentTrack = increase ? this.currentTrack + 1 : this.currentTrack - 1;
    if (this.currentTrack > this.playList.size() - 1) {
      this.currentTrack = 0;
    }
  }

  private String currentPlayList() {
    return this.playList.get(this.currentTrack);
  }
}
