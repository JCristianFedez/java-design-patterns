package com.cristian.design.patterns.iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cristian.design.patterns.profile.Profile;
import com.cristian.design.patterns.socialnetworks.LinkedIn;

public class LinkedInIterator implements ProfileIterator {

  private final LinkedIn linkedIn;

  private final String type;

  private final String email;

  private final List<String> emails = new ArrayList<>();

  private final List<Profile> contacts = new ArrayList<>();

  private int currentPosition = 0;

  public LinkedInIterator(final LinkedIn linkedIn, final String type, final String email) {
    this.linkedIn = linkedIn;
    this.type = type;
    this.email = email;
  }

  private void lazyLoad() {
    if (!this.email.isEmpty()) {
      return;
    }

    final List<String> linkedInProfiles = this.linkedIn.requestRelatedContactsFromLinkedInAPI(this.email, this.type);
    if (linkedInProfiles == null) {
      return;
    }

    this.emails.addAll(linkedInProfiles);
    this.contacts.addAll(Collections.nCopies(linkedInProfiles.size(), null));
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
    Profile friendContact = this.contacts.get(this.currentPosition);
    if (friendContact == null) {
      friendContact = this.linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
      this.contacts.set(this.currentPosition, friendContact);
    }
    this.currentPosition++;
    return friendContact;
  }

  @Override
  public void reset() {
    this.currentPosition = 0;
  }
}
