package com.cristian.design.patterns;

import java.util.List;

import com.cristian.design.patterns.models.King;
import com.cristian.design.patterns.models.Queen;
import com.cristian.design.patterns.models.Royalty;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServantDemo {

  public static void main(String[] args) {
    scenario(new Servant("Jenkins"), 1);
    scenario(new Servant("Travis"), 0);
  }

  private static void scenario(final Servant servant, final int compliment) {
    final Royalty king = new King();
    final Royalty queen = new Queen();

    final List<Royalty> guests = List.of(king, queen);

    // feed
    servant.feed(king);
    servant.feed(queen);

    // Serve drinks
    servant.giveWine(king);
    servant.giveWine(queen);

    // Compliment
    servant.giveCompliments(guests.get(compliment));

    // Outcome of the night
    guests.forEach(Royalty::changeMood);

    if (servant.checkIfYouWillBeHanged(guests)) {
      LOGGER.info("{} will live another day", servant.getName());
    } else {
      LOGGER.info("Poor {}. His days are numbered", servant.getName());
    }
  }
}
