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
    log.debug("Remote: power toggle");
    if (device.isEnabled()) {
      device.disable();
    } else {
      device.enable();
    }
  }

  @Override
  public void volumeDown() {
    log.debug("Remote: volume down");
    device.setVolume(device.getVolume() - 10);
  }

  @Override
  public void volumeUp() {
    log.debug("Remote: volume up");
    device.setVolume(device.getVolume() + 10);
  }

  @Override
  public void channelDown() {
    log.debug("Remote: channel down");
    device.setChannel(device.getChannel() - 1);
  }

  @Override
  public void channelUp() {
    log.debug("Remote: channel up");
    device.setChannel(device.getChannel() + 1);
  }
}
