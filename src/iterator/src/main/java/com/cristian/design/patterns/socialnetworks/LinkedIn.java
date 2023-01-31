package com.cristian.design.patterns.socialnetworks;

import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.iterators.LinkedInIterator;
import com.cristian.design.patterns.iterators.ProfileIterator;
import com.cristian.design.patterns.profile.Profile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedIn implements SocialNetwork {

  private final List<Profile> profiles;

  public LinkedIn(final List<Profile> profiles) {
    this.profiles = profiles != null ? profiles : new ArrayList<>();
  }

  public Profile requestContactInfoFromLinkedInAPI(final String profileEmail) {
    // Aquí habría una solicitud POST a uno de los puntos finales de la API de Facebook.En su lugar, emulamos una larga conexión de red, lo
    // que esperaría en la vida real...
    this.simulateNetworkLatency();
    log.debug("LinkedIn: Cargando perfil {} en la red", profileEmail);

    return this.findContact(profileEmail);
  }

  public List<String> requestRelatedContactsFromLinkedInAPI(final String profileEmail, final String contactType) {
    // Aquí habría una solicitud POST a uno de los puntos finales de la API de Facebook.En su lugar, emulamos una larga conexión de red, lo
    // que esperaría en la vida real...
    this.simulateNetworkLatency();
    log.debug("LinkedIn: Cargando {} lista de {} en la red", contactType, profileEmail);

    final Profile profile = this.findContact(profileEmail);
    if (profile != null) {
      return profile.getContacts(contactType);
    }
    return null;
  }

  private Profile findContact(final String profileEmail) {
    return this.profiles.stream().filter(profile -> profile.getEmail().equals(profileEmail))
        .findFirst()
        .orElse(null);
  }

  private void simulateNetworkLatency() {
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public ProfileIterator createFriendsIterator(final String profileEmail) {
    return new LinkedInIterator(this, "friends", profileEmail);
  }

  @Override
  public ProfileIterator createCoworkersIterator(final String profileEmail) {
    return new LinkedInIterator(this, "coworkers", profileEmail);
  }
}
