package iterator.socialnetworks;

import java.util.ArrayList;
import java.util.List;

import commons.logger.Logger;
import iterator.iterators.FacebookIterator;
import iterator.iterators.ProfileIterator;
import iterator.profile.Profile;

public class Facebook implements SocialNetwork {

  private static final Logger LOGGER = Logger.fromType(Facebook.class);

  private final List<Profile> profiles;

  public Facebook(final List<Profile> profiles) {
    this.profiles = profiles == null ? new ArrayList<>() : profiles;
  }

  public Profile requestProfileFromFacebook(final String profileEmail) {
    // Aquí habría una solicitud POST a uno de los puntos finales de la API de Facebook.En su lugar, emulamos una larga conexión de red, lo
    // que esperaría en la vida real...
    this.simulateNetworkLatency();

    LOGGER.debug("Facebook: Cargando perfil %s sobre la red", profileEmail);
    return this.findProfile(profileEmail);
  }

  public List<String> requestProfileFriendsFromFacebook(final String profileEmail, final String contactType) {
    // Aquí habría una solicitud POST a uno de los puntos finales de la API de Facebook.En su lugar, emulamos una larga conexión de red, lo
    // que esperaría en la vida real...
    this.simulateNetworkLatency();
    LOGGER.debug("Facebook: Cargando %s lista de %s sobre la red", contactType, profileEmail);

    final Profile profile = this.findProfile(profileEmail);
    return profile != null ? profile.getContacts(contactType) : null;
  }

  private Profile findProfile(final String profileEmail) {
    return this.profiles.stream()
        .filter(profile -> profile.getEmail().equals(profileEmail))
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
    return new FacebookIterator(this, "friends", profileEmail);
  }

  @Override
  public ProfileIterator createCoworkersIterator(final String profileEmail) {
    return new FacebookIterator(this, "coworkers", profileEmail);
  }
}
