package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static void main(String[] args) {
    final String[] queriesOr = new String[]{"many", "Annabel"};
    Finder finder = Finders.expandedFinder(queriesOr);
    List<String> res = finder.find(text());
    log.info("the result of expanded(or) query[{}] is {}", Arrays.toString(queriesOr), res);

    final String[] queriesAnd = new String[]{"Annabel", "my"};
    finder = Finders.specializedFinder(queriesAnd);
    res = finder.find(text());
    log.info("the result of specialized(and) query[{}] is {}", Arrays.toString(queriesAnd), res);

    finder = Finders.advancedFinder("it was", "kingdom", "sea");
    res = finder.find(text());
    log.info("the result of advanced query is {}", res);

    res = Finders.filteredFinder(" was ", "many", "child").find(text());
    log.info("the result of filtered query is {}", res);
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
