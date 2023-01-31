package com.cristian.design.patterns.remotes;

import com.cristian.design.patterns.devices.Device;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedRemote extends BasicRemote {

  public AdvancedRemote(Device device) {
    super(device);
  }

  public void mute() {
    log.debug("Remote: mute");
    device.setVolume(0);
  }
}
