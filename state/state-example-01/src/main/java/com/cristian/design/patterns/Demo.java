package com.cristian.design.patterns;

import com.cristian.design.patterns.ui.Player;
import com.cristian.design.patterns.ui.UI;

public class Demo {

  public static void main(String[] args) {
    final Player player = new Player();
    final UI ui = new UI(player);
    ui.init();
  }
}
