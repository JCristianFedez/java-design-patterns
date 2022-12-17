package com.cristian.design.patterns.remotes;

import com.cristian.design.patterns.devices.Device;
import com.cristian.design.patterns.logger.Logger;

public class AdvancedRemote extends BasicRemote {

  private static final Logger LOGGER = Logger.fromType(AdvancedRemote.class);

  public AdvancedRemote(Device device) {
    super(device);
  }

  public void mute() {
    LOGGER.debug("Remote: mute");
    device.setVolume(0);
  }
}
