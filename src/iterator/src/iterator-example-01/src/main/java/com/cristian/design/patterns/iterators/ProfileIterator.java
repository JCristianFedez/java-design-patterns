package com.cristian.design.patterns.iterators;

import com.cristian.design.patterns.profile.Profile;

public interface ProfileIterator {

  boolean hasNext();

  Profile getNext();

  void reset();
}
