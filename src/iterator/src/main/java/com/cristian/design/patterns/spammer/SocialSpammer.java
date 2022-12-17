package com.cristian.design.patterns.spammer;

import com.cristian.design.patterns.iterators.ProfileIterator;
import com.cristian.design.patterns.logger.Logger;
import com.cristian.design.patterns.socialnetworks.SocialNetwork;

public class SocialSpammer {

  private static final Logger LOGGER = Logger.fromType(SocialSpammer.class);

  private final SocialNetwork network;

  private ProfileIterator iterator;

  public SocialSpammer(final SocialNetwork network) {
    this.network = network;
  }

  public void sendSpamToFriends(final String profileEmail, final String message) {
    LOGGER.debug("Iterando sobre amigos");
    this.iterator = this.network.createFriendsIterator(profileEmail);
    while (this.iterator.hasNext()) {
      this.sendMessage(this.iterator.getNext().getEmail(), message);
    }
  }

  public void sendSpamToCoworkers(final String profileEmail, final String message) {
    LOGGER.debug("Iterando sobre compañeros");
    this.iterator = this.network.createCoworkersIterator(profileEmail);
    while (this.iterator.hasNext()) {
      this.sendMessage(this.iterator.getNext().getEmail(), message);
    }
  }

  private void sendMessage(final String email, final String message) {
    LOGGER.debug("Enviando mensaje a %s. Cuerpo del mensaje: %s", email, message);
  }
}
