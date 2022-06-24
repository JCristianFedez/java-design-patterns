package state;

import state.ui.Player;
import state.ui.UI;

public class Demo {

  public static void main(String[] args) {
    final Player player = new Player();
    final UI ui = new UI(player);
    ui.init();
  }
}
