package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

import com.cristian.design.patterns.logger.Logger;

public class Demo {

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    final String[] queriesOr = new String[]{"many", "Annabel"};
    Finder finder = Finders.expandedFinder(queriesOr);
    List<String> res = finder.find(text());
    LOGGER.info("the result of expanded(or) query[%s] is %s", Arrays.toString(queriesOr), res);

    final String[] queriesAnd = new String[]{"Annabel", "my"};
    finder = Finders.specializedFinder(queriesAnd);
    res = finder.find(text());
    LOGGER.info("the result of specialized(and) query[%s] is %s", Arrays.toString(queriesAnd), res);

    finder = Finders.advancedFinder("it was", "kingdom", "sea");
    res = finder.find(text());
    LOGGER.info("the result of advanced query is %s", res);

    res = Finders.filteredFinder(" was ", "many", "child").find(text());
    LOGGER.info("the result of filtered query is %s", res);
  }

  private static String text() {
    return
        "It was many and many a year ago,\n"
            + "In a kingdom by the sea,\n"
            + "That a maiden there lived whom you may know\n"
            + "By the name of ANNABEL LEE;\n"
            + "And this maiden she lived with no other thought\n"
            + "Than to love and be loved by me.\n"
            + "I was a child and she was a child,\n"
            + "In this kingdom by the sea;\n"
            + "But we loved with a love that was more than love-\n"
            + "I and my Annabel Lee;\n"
            + "With a love that the winged seraphs of heaven\n"
            + "Coveted her and me.";
  }
}
