package iterator.iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iterator.profile.Profile;
import iterator.socialnetworks.Facebook;

public class FacebookIterator implements ProfileIterator {

  private final Facebook facebook;

  private final String type;

  private final String email;

  private final List<String> emails = new ArrayList<>();

  private final List<Profile> profiles = new ArrayList<>();

  private int currentPosition = 0;

  public FacebookIterator(final Facebook facebook, final String type, final String email) {
    this.facebook = facebook;
    this.type = type;
    this.email = email;
  }

  private void lazyLoad() {
    if (!this.emails.isEmpty()) {
      return;
    }

    final List<String> facebookProfiles = this.facebook.requestProfileFriendsFromFacebook(this.email, this.type);
    if (facebookProfiles == null) {
      return;
    }

    this.emails.addAll(facebookProfiles);
    this.profiles.addAll(Collections.nCopies(facebookProfiles.size(), null));
  }

  @Override
  public boolean hasNext() {
    this.lazyLoad();
    return this.currentPosition < this.emails.size();
  }

  @Override
  public Profile getNext() {
    if (!this.hasNext()) {
      return null;
    }

    final String friendEmail = this.emails.get(this.currentPosition);
    Profile friendProfile = this.profiles.get(this.currentPosition);
    if (friendProfile == null) {
      friendProfile = this.facebook.requestProfileFromFacebook(friendEmail);
      this.profiles.set(this.currentPosition, friendProfile);
    }
    this.currentPosition++;
    return friendProfile;
  }

  @Override
  public void reset() {
    this.currentPosition = 0;
  }
}
