package com.cristian.design.patterns.example1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final KingJoffrey kingJoffrey = new KingJoffrey();

    final KingsHand kingsHand = new KingsHand();
    kingsHand.registerObserver(kingJoffrey, Event.TRAITOR_DETECTED);
    kingsHand.registerObserver(kingJoffrey, Event.STARK_SIGHTED);
    kingsHand.registerObserver(kingJoffrey, Event.WARSHIPS_APPROACHING);
    kingsHand.registerObserver(kingJoffrey, Event.WHITE_WALKERS_SIGHTED);

    final LordVarys lordVarys = new LordVarys();
    lordVarys.registerObserver(kingsHand, Event.TRAITOR_DETECTED);
    lordVarys.registerObserver(kingsHand, Event.WHITE_WALKERS_SIGHTED);

    final Scout scout = new Scout();
    scout.registerObserver(kingsHand, Event.WARSHIPS_APPROACHING);
    scout.registerObserver(lordVarys, Event.WHITE_WALKERS_SIGHTED);

    final LordBaelish lordBaelish = new LordBaelish(kingsHand, Event.STARK_SIGHTED);

    final List<EventEmitter> emitters = Arrays.asList(kingsHand, lordBaelish, lordVarys, scout);

    Arrays.stream(Weekday.values())
        .<Consumer<? super EventEmitter>>map(day -> emitter -> emitter.timePasses(day))
        .forEach(emitters::forEach);
  }
}
