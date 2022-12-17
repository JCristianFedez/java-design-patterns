package com.cristian.design.patterns.devices;

import com.cristian.design.patterns.logger.Logger;

public class Tv implements Device {

  private static final Logger LOGGER = Logger.fromType(Radio.class);

  private boolean on = false;

  private int volume = 30;

  private int channel = 1;

  @Override
  public boolean isEnabled() {
    return on;
  }

  @Override
  public void enable() {
    on = true;
  }

  @Override
  public void disable() {
    on = false;
  }

  @Override
  public int getVolume() {
    return volume;
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
    return channel;
  }

  @Override
  public void setChannel(int channel) {
    this.channel = channel;
  }

  @Override
  public void printStatus() {
    LOGGER.debug("------------------------------------");
    LOGGER.debug("| I'm TV set.");
    LOGGER.debug("| I'm " + (on ? "enabled" : "disabled"));
    LOGGER.debug("| Current volume is " + volume + " percent");
    LOGGER.debug("| Current channel is " + channel);
    LOGGER.debug("------------------------------------\n");
  }
}
