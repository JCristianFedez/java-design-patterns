package com.cristian.design.patterns.socialnetworks;

import com.cristian.design.patterns.iterators.ProfileIterator;

public interface SocialNetwork {

  ProfileIterator createFriendsIterator(final String profileEmail);

  ProfileIterator createCoworkersIterator(final String profileEmail);
}
