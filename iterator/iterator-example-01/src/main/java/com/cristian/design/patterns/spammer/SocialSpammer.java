package com.cristian.design.patterns.spammer;

import com.cristian.design.patterns.iterators.ProfileIterator;
import com.cristian.design.patterns.socialnetworks.SocialNetwork;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocialSpammer {

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
    LOGGER.debug("Enviando mensaje a {}. Cuerpo del mensaje: {}", email, message);
  }
}
