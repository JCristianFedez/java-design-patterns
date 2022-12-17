package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cristian.design.patterns.logger.Logger;
import com.cristian.design.patterns.profile.Profile;
import com.cristian.design.patterns.socialnetworks.Facebook;
import com.cristian.design.patterns.socialnetworks.LinkedIn;
import com.cristian.design.patterns.socialnetworks.SocialNetwork;
import com.cristian.design.patterns.spammer.SocialSpammer;

public class Demo {

  private static final Scanner scanner = new Scanner(System.in);

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    LOGGER.debug("Especifique la red social para apuntar a la herramienta de spam (predeterminado: Facebook):");
    LOGGER.debug("1. Facebook");
    LOGGER.debug("2. LinkedIn");
    final String choise = scanner.nextLine();

    final SocialNetwork network;
    if (choise.equals("2")) {
      network = new LinkedIn(createTestProfiles());
    } else {
      network = new Facebook(createTestProfiles());
    }

    final SocialSpammer spammer = new SocialSpammer(network);
    spammer.sendSpamToFriends("anna.smith@bing.com",
        "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
    spammer.sendSpamToCoworkers("anna.smith@bing.com",
        "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
  }

  private static List<Profile> createTestProfiles() {
    return Arrays.asList(
        new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com",
            "coworkers:sam@amazon.com"),
        new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"),
        new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"),
        new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"),
        new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com",
            "friends:catwoman@yahoo.com"),
        new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com")
    );
  }
}
