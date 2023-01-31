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
    LOGGER.debug("------------------------------------");
    LOGGER.debug("| I'm radio.");
    LOGGER.debug("| I'm " + (on ? "enabled" : "disabled"));
    LOGGER.debug("| Current volume is " + volume + " percent");
    LOGGER.debug("| Current channel is " + channel);
    LOGGER.debug("------------------------------------\n");
  }
}
