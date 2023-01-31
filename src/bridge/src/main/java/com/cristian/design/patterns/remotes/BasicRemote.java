package com.cristian.design.patterns.remotes;

import com.cristian.design.patterns.devices.Device;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicRemote implements Remotes {

  protected Device device;

  public BasicRemote() {
  }

  public BasicRemote(Device device) {
    this.device = device;
  }

  @Override
  public void power() {
    LOGGER.debug("Remote: power toggle");
    if (device.isEnabled()) {
      device.disable();
    } else {
      device.enable();
    }
  }

  @Override
  public void volumeDown() {
    LOGGER.debug("Remote: volume down");
    device.setVolume(device.getVolume() - 10);
  }

  @Override
  public void volumeUp() {
    LOGGER.debug("Remote: volume up");
    device.setVolume(device.getVolume() + 10);
  }

  @Override
  public void channelDown() {
    LOGGER.debug("Remote: channel down");
    device.setChannel(device.getChannel() - 1);
  }

  @Override
  public void channelUp() {
    LOGGER.debug("Remote: channel up");
    device.setChannel(device.getChannel() + 1);
  }
}
