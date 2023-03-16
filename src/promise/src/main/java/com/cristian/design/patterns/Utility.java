package com.cristian.design.patterns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utility {

  /**
   * Calculates character frequency of the file provided.
   *
   * @param fileLocation location of the file.
   * @return a map of character to its frequency, an empty map if file does not exist.
   */
  public static Map<Character, Long> characterFrequency(String fileLocation) {
    try (var bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
      return bufferedReader.lines()
          .flatMapToInt(String::chars)
          .mapToObj(x -> (char) x)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return Collections.emptyMap();
  }

  /**
   * Return the character with the lowest frequency, if exists.
   *
   * @return the character, {@code Optional.empty()} otherwise.
   */
  public static Character lowestFrequencyChar(Map<Character, Long> charFrequency) {
    return charFrequency
        .entrySet()
        .stream()
        .min(Comparator.comparingLong(Entry::getValue))
        .map(Entry::getKey)
        .orElseThrow();
  }

  /**
   * Count the number of lines in a file.
   *
   * @return number of lines, 0 if file does not exist.
   */
  public static Integer countLines(String fileLocation) {
    try (var bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
      return (int) bufferedReader.lines().count();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return 0;
  }

  /**
   * Downloads the contents from the given urlString, and stores it in a temporary directory.
   *
   * @return the absolute path of the file downloaded.
   */
  public static String downloadFile(String urlString) throws IOException {
    LOGGER.info("Downloading contents from url: {}", urlString);
    var url = new URL(urlString);
    var file = File.createTempFile("promise_pattern", null);
    try (var bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        var writer = new FileWriter(file)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        writer.write(line);
        writer.write("\n");
      }
      LOGGER.info("File downloaded at: {}", file.getAbsolutePath());
      return file.getAbsolutePath();
    }
  }
}