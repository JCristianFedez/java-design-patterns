package bridge.remotes;

import bridge.devices.Device;
import commons.logger.Logger;

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
