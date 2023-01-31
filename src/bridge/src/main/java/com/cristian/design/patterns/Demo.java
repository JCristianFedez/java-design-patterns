package com.cristian.design.patterns;

import com.cristian.design.patterns.devices.Device;
import com.cristian.design.patterns.devices.Radio;
import com.cristian.design.patterns.devices.Tv;
import com.cristian.design.patterns.remotes.AdvancedRemote;
import com.cristian.design.patterns.remotes.BasicRemote;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static void main(String[] args) {
    testDevice(new Tv());
    testDevice(new Radio());
  }

  private static void testDevice(final Device device) {
    log.debug("Tests with basic remote");
    final BasicRemote basicRemote = new BasicRemote(device);
    basicRemote.power();
    device.printStatus();

    log.debug("Tests with advanced remote.");
    final AdvancedRemote advancedRemote = new AdvancedRemote(device);
    advancedRemote.power();
    advancedRemote.mute();
    device.printStatus();
  }
}
