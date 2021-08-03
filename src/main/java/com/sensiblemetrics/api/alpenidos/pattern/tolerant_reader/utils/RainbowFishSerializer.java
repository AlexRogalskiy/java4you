package com.sensiblemetrics.api.alpenidos.pattern.tolerant_reader.utils;

import com.google.common.collect.ImmutableMap;
import com.sensiblemetrics.api.alpenidos.pattern.tolerant_reader.model.RainbowFish;
import com.sensiblemetrics.api.alpenidos.pattern.tolerant_reader.model.RainbowFishV2;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.Map;

/**
 * RainbowFishSerializer provides methods for reading and writing {@link RainbowFish} objects to
 * file. Tolerant Reader pattern is implemented here by serializing maps instead of
 * {@link RainbowFish} objects. This way the reader does not break even though new properties are
 * added to the schema.
 */
@UtilityClass
public final class RainbowFishSerializer {

    /**
     * Write V1 RainbowFish to file
     */
    public static void writeV1(final RainbowFish rainbowFish, final String filename) throws IOException {
        final Map<String, String> map = ImmutableMap.<String, String>builder()
            .put("name", rainbowFish.getName())
            .put("age", String.format("%d", rainbowFish.getAge()))
            .put("lengthMeters", String.format("%d", rainbowFish.getLengthMeters()))
            .put("weightTons", String.format("%d", rainbowFish.getWeightTons()))
            .build();

        try (final FileOutputStream fileOut = new FileOutputStream(filename);
             final ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(map);
        }
    }

    /**
     * Write V2 RainbowFish to file
     */
    public static void writeV2(final RainbowFishV2 rainbowFish, final String filename) throws IOException {
        final Map<String, String> map = ImmutableMap.<String, String>builder()
            .put("name", rainbowFish.getName())
            .put("age", String.format("%d", rainbowFish.getAge()))
            .put("lengthMeters", String.format("%d", rainbowFish.getLengthMeters()))
            .put("weightTons", String.format("%d", rainbowFish.getWeightTons()))
            .put("angry", Boolean.toString(rainbowFish.isAngry()))
            .put("hungry", Boolean.toString(rainbowFish.isHungry()))
            .put("sleeping", Boolean.toString(rainbowFish.isSleeping()))
            .build();

        try (final FileOutputStream fileOut = new FileOutputStream(filename);
             final ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(map);
        }
    }

    /**
     * Read V1 RainbowFish from file
     */
    public static RainbowFish readV1(final String filename) throws IOException, ClassNotFoundException {
        Map<String, String> map;
        try (final FileInputStream fileIn = new FileInputStream(filename);
             final ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            map = (Map<String, String>) objIn.readObject();
        }
        return new RainbowFish(
            map.get("name"),
            Integer.parseInt(map.get("age")),
            Integer.parseInt(map.get("lengthMeters")),
            Integer.parseInt(map.get("weightTons"))
        );
    }
}
