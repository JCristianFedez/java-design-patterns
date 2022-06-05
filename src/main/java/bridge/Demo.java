package bridge;

import bridge.devices.Device;
import bridge.devices.Radio;
import bridge.devices.Tv;
import bridge.remotes.AdvancedRemote;
import bridge.remotes.BasicRemote;
import commons.logger.Logger;

public class Demo {

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    testDevice(new Tv());
    testDevice(new Radio());
  }

  private static void testDevice(final Device device) {
    LOGGER.debug("Tests with basic remote");
    final BasicRemote basicRemote = new BasicRemote(device);
    basicRemote.power();
    device.printStatus();

    LOGGER.debug("Tests with advanced remote.");
    final AdvancedRemote advancedRemote = new AdvancedRemote(device);
    advancedRemote.power();
    advancedRemote.mute();
    device.printStatus();
  }
}
