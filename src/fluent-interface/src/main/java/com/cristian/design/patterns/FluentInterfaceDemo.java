package com.cristian.design.patterns;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;

import com.cristian.design.patterns.fluentiterable.lazy.LazyFluentIterable;
import com.cristian.design.patterns.fluentiterable.simple.SimpleFluentIterable;

public class FluentInterfaceDemo {

  public static void main(String[] args) {
    new FluentInterfaceDemo().run();
  }

  private void run() {
    final List<Integer> integers = List.of(1, -61, 14, -22, 18, -87, 6, 64, -82, 26, -98, 97, 45, 23, 2, -68);

    prettyPrint("The initial list contains: ", integers);

    final List<Integer> firstFiveNegatives = SimpleFluentIterable
        .fromCopyOf(integers)
        .filter(negatives())
        .first(3)
        .asList();
    prettyPrint("The first three negative values are: ", firstFiveNegatives);

    final List<Integer> lastTwoPositives = SimpleFluentIterable
        .fromCopyOf(integers)
        .filter(positives())
        .last(2)
        .asList();
    prettyPrint("The last two positives values are: ", lastTwoPositives);

    SimpleFluentIterable
        .fromCopyOf(integers)
        .filter(number -> number % 2 == 0)
        .first()
        .ifPresent(evenNumber -> System.out.printf("The first even number is {}%n", evenNumber));

    final List<String> transformedList = SimpleFluentIterable
        .fromCopyOf(integers)
        .filter(negatives())
        .map(transformToString())
        .asList();
    prettyPrint("A string-mapped list of negative number contains: ", transformedList);

    final List<String> lastTwoFirstFourStringMapped = LazyFluentIterable
        .from(integers)
        .filter(positives())
        .first(4)
        .last(2)
        .map(number -> "String[" + number + "]")
        .asList();
    prettyPrint("The lazy list contains the last two of the first four positive numbers mapped to Strings: ", lastTwoFirstFourStringMapped);

    LazyFluentIterable
        .from(integers)
        .filter(negatives())
        .first(2)
        .last()
        .ifPresent(number -> System.out.printf("Last amongst first two negatives: {}%n", number));
  }

  private Function<Integer, String> transformToString() {
    return integer -> "String[" + integer + "]";
  }

  private Predicate<? super Integer> negatives() {
    return integer -> integer < 0;
  }

  private Predicate<? super Integer> positives() {
    return integer -> integer > 0;
  }

  private <T> void prettyPrint(final String prefix, final Iterable<T> iterable) {
    prettyPrint(", ", prefix, iterable);
  }

  private <T> void prettyPrint(final String delimiter, final String prefix, final Iterable<T> iterable) {
    final StringJoiner joiner = new StringJoiner(delimiter, prefix, ".");
    iterable.forEach(t -> joiner.add(t.toString()));
    System.out.println(joiner);
  }
}
