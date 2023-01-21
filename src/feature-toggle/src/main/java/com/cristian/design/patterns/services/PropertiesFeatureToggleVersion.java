package com.cristian.design.patterns.services;

import java.util.Properties;

import com.cristian.design.patterns.user.User;

import lombok.Getter;

@Getter
public class PropertiesFeatureToggleVersion implements Service {

  private final boolean enhanced;

  public PropertiesFeatureToggleVersion(final Properties properties) {
    if (properties == null) {
      throw new IllegalArgumentException("No Properties Provided.");
    }
    try {
      this.enhanced = (boolean) properties.get("enhancedWelcome");
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid Enhancement Settings Provided.");
    }
  }

  @Override
  public String welcomeMessage(final User user) {
    if (isEnhanced()) {
      return String.format("Welcome %s. You're using the enhanced welcome message.", user);
    }
    return "Welcome to the application";
  }

}
