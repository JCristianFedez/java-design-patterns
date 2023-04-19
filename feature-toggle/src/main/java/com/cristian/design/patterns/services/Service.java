package com.cristian.design.patterns.services;

import com.cristian.design.patterns.user.User;

public interface Service {

  String welcomeMessage(User user);

  boolean isEnhanced();
}
