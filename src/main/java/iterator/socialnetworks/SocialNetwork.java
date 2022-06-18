package iterator.socialnetworks;

import iterator.iterators.ProfileIterator;

public interface SocialNetwork {

  ProfileIterator createFriendsIterator(final String profileEmail);

  ProfileIterator createCoworkersIterator(final String profileEmail);
}
