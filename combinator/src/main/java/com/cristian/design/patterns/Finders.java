package com.cristian.design.patterns;

public class Finders {

  private Finders() {
  }

  public static Finder advancedFinder(final String query, final String orQuery, final String notQuery) {
    return Finder.contains(query)
        .or(Finder.contains(orQuery))
        .not(Finder.contains(notQuery));
  }

  /**
   * Filtered finder looking a query with excluded queries as well.
   */
  public static Finder filteredFinder(final String query, final String... excludeQueries) {
    Finder finder = Finder.contains(query);
    for (final String excludeQuery : excludeQueries) {
      finder = finder.not(Finder.contains(excludeQuery));
    }
    return finder;
  }

  /**
   * Every next query is looked in previous result.
   */
  public static Finder specializedFinder(final String... queries) {
    Finder finder = null;
    for (final String query : queries) {
      finder = finder == null ? Finder.contains(query) : finder.and(Finder.contains(query));
    }
    return finder;
  }

  /**
   * Looking for alternatives.
   */
  public static Finder expandedFinder(final String... queries) {
    Finder finder = null;
    for (final String query : queries) {
      finder = finder == null ? Finder.contains(query) : finder.or(Finder.contains(query));
    }
    return finder;
  }
}
