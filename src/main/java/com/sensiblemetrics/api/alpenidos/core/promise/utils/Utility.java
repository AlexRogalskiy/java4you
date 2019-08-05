package com.sensiblemetrics.api.alpenidos.core.promise.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

/**
 * Utility to perform various operations
 */
@Slf4j
@UtilityClass
public class Utility {

    /**
     * Calculates character frequency of the file provided.
     *
     * @param fileLocation location of the file.
     * @return a map of character to its frequency, an empty map if file does not exist.
     */
    public static Map<Character, Integer> characterFrequency(final String fileLocation) {
        final Map<Character, Integer> characterToFrequency = new HashMap<>();
        try (final Reader reader = new FileReader(fileLocation);
             final BufferedReader bufferedReader = new BufferedReader(reader)) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                for (final char c : line.toCharArray()) {
                    characterToFrequency.compute(c, (key, old) -> Optional.ofNullable(old).map(v -> v + 1).orElse(Integer.valueOf(1)));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return characterToFrequency;
    }

    /**
     * @return the character with lowest frequency if it exists, {@code Optional.empty()} otherwise.
     */
    public static Character lowestFrequencyChar(final Map<Character, Integer> charFrequency) {
        final Entry<Character, Integer> min = Collections.min(charFrequency.entrySet(), Comparator.comparing(Entry::getValue));
        return min.getKey();
    }

    /**
     * @return number of lines in the file at provided location. 0 if file does not exist.
     */
    public static Integer countLines(final String fileLocation) {
        int lineCount = 0;
        try (final Reader reader = new FileReader(fileLocation);
             final BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lineCount;
    }

    /**
     * Downloads the contents from the given urlString, and stores it in a temporary directory.
     *
     * @return the absolute path of the file downloaded.
     */
    public static String downloadFile(final String urlString) throws IOException {
        log.info("Downloading contents from url: {}", urlString);
        final URL url = new URL(urlString);
        final File file = File.createTempFile("promise_pattern", null);
        try (final Reader reader = new InputStreamReader(url.openStream());
             final BufferedReader bufferedReader = new BufferedReader(reader);
             final FileWriter writer = new FileWriter(file)) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                writer.write(line);
                writer.write("\n");
            }
            log.info("File downloaded at: {}", file.getAbsolutePath());
            return file.getAbsolutePath();
        } catch (IOException ex) {
            throw ex;
        }
    }
}
