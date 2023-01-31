package com.cristian.design.patterns.devices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Radio implements Device {

  private boolean on = false;

  private int volume = 30;

  private int channel = 1;

  @Override
  public boolean isEnabled() {
    return this.on;
  }

  @Override
  public void enable() {
    this.on = true;
  }

  @Override
  public void disable() {
    this.on = false;
  }

  @Override
  public int getVolume() {
    return this.volume;
  }

  @Override
  public void setVolume(int volume) {
    if (this.volume > 100) {
      this.volume = 100;
    } else if (this.volume < 0) {
      this.volume = 0;
    } else {
      this.volume = volume;
    }
  }

  @Override
  public int getChannel() {
    return this.channel;
  }

  @Override
  public void setChannel(int channel) {
    this.channel = channel;
  }

  @Override
  public void printStatus() {
    log.debug("------------------------------------");
    log.debug("| I'm radio.");
    log.debug("| I'm " + (on ? "enabled" : "disabled"));
    log.debug("| Current volume is " + volume + " percent");
    log.debug("| Current channel is " + channel);
    log.debug("------------------------------------\n");
  }
}
