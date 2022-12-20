package com.cristian.design.patterns;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Functional interface to find lines in text.
 */
public interface Finder {

  /**
   * Simple implementation of function {@link #find(String)}.
   */
  static Finder contains(final String word) {
    return txt -> Stream.of(txt.split("\n"))
        .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
        .collect(Collectors.toList());
  }

  default Finder not(final Finder notFinder) {
    return txt -> {
      final List<String> res = find(txt);
      res.removeAll(notFinder.find(txt));
      return res;
    };
  }

  default Finder or(final Finder orFinder) {
    return txt -> {
      final List<String> res = find(txt);
      res.addAll(orFinder.find(txt));
      return res;
    };
  }

  default Finder and(final Finder andFinder) {
    return txt -> find(txt).stream()
        .flatMap(line -> andFinder.find(line).stream())
        .collect(Collectors.toList());
  }

  /**
   * The function to find lines in text.
   */
  List<String> find(final String text);
}
