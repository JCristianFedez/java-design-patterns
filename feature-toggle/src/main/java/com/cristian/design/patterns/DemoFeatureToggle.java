package com.cristian.design.patterns;

import java.util.Properties;

import com.cristian.design.patterns.services.PropertiesFeatureToggleVersion;
import com.cristian.design.patterns.services.TieredFeatureToggleVersion;
import com.cristian.design.patterns.user.User;
import com.cristian.design.patterns.user.UserGroup;

public class DemoFeatureToggle {

  public static void main(String[] args) {
    new DemoFeatureToggle().run();
  }

  private void run() {
    checkProperties();
    checkPaidUserFreeUser();
  }

  private void checkPaidUserFreeUser() {
    System.out.println("============= CHECK PAID/FREE SERVICE =============");
    final TieredFeatureToggleVersion service = new TieredFeatureToggleVersion();

    final User paidUser = new User("JAmie Coder");
    final User freeUser = new User("Alan Defect");

    UserGroup.addUserToPaidGroup(paidUser);
    UserGroup.addUserToFreeGroup(freeUser);

    System.out.println("============= PAID SERVICE =============");
    System.out.println(service.welcomeMessage(paidUser));
    System.out.println("============= FREE SERVICE =============");
    System.out.println(service.welcomeMessage(freeUser));
  }

  private void checkProperties() {
    System.out.println("============= CHECK PROPERTIES SERVICE =============");
    System.out.println("============= PROPERTIES: ENHANCED ON =============");
    onEnhancedWelcome();
    System.out.println("============= PROPERTIES: ENHANCED OFF =============");
    offEnhancedWelcome();
  }

  private void offEnhancedWelcome() {
    final Properties properties = new Properties();
    properties.put("enhancedWelcome", false);
    final PropertiesFeatureToggleVersion service = new PropertiesFeatureToggleVersion(properties);
    final User user = new User("Jamie No Code");
    System.out.println(service.welcomeMessage(user));
  }

  private void onEnhancedWelcome() {
    final Properties properties = new Properties();
    properties.put("enhancedWelcome", true);
    final PropertiesFeatureToggleVersion service = new PropertiesFeatureToggleVersion(properties);
    final User user = new User("Jamie No Code");
    System.out.println(service.welcomeMessage(user));
  }

}
