package com.sensiblemetrics.api.alpenidos.core.tolerant_reader;

import com.sensiblemetrics.api.alpenidos.core.tolerant_reader.model.RainbowFish;
import com.sensiblemetrics.api.alpenidos.core.tolerant_reader.model.RainbowFishV2;
import com.sensiblemetrics.api.alpenidos.core.tolerant_reader.utils.RainbowFishSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Tolerant Reader is an integration pattern that helps creating robust communication systems. The
 * idea is to be as tolerant as possible when reading data from another service. This way, when the
 * communication schema changes, the readers must not break.
 * <p>
 * In this example we use Java serialization to write representations of {@link RainbowFish} objects
 * to file. {@link RainbowFish} is the initial version which we can easily read and write using
 * {@link RainbowFishSerializer} methods. {@link RainbowFish} then evolves to {@link RainbowFishV2}
 * and we again write it to file with a method designed to do just that. However, the reader client
 * does not know about the new format and still reads with the method designed for V1 schema.
 * Fortunately the reading method has been designed with the Tolerant Reader pattern and does not
 * break even though {@link RainbowFishV2} has new fields that are serialized.
 */
@Slf4j
public class TolerantReaderPatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        // Write V1
        final RainbowFish fishV1 = new RainbowFish("Zed", 10, 11, 12);
        log.info("fishV1 name={} age={} length={} weight={}", fishV1.getName(), fishV1.getAge(), fishV1.getLengthMeters(), fishV1.getWeightTons());
        RainbowFishSerializer.writeV1(fishV1, "fish1.out");

        // Read V1
        final RainbowFish deserializedFishV1 = RainbowFishSerializer.readV1("fish1.out");
        log.info("deserializedFishV1 name={} age={} length={} weight={}", deserializedFishV1.getName(), deserializedFishV1.getAge(), deserializedFishV1.getLengthMeters(), deserializedFishV1.getWeightTons());

        // Write V2
        final RainbowFishV2 fishV2 = new RainbowFishV2("Scar", 5, 12, 15, true, true, true);
        log.info("fishV2 name={} age={} length={} weight={} sleeping={} hungry={} angry={}", fishV2.getName(), fishV2.getAge(), fishV2.getLengthMeters(), fishV2.getWeightTons(), fishV2.isHungry(), fishV2.isAngry(), fishV2.isSleeping());
        RainbowFishSerializer.writeV2(fishV2, "fish2.out");

        // Read V2 with V1 method
        final RainbowFish deserializedFishV2 = RainbowFishSerializer.readV1("fish2.out");
        log.info("deserializedFishV2 name={} age={} length={} weight={}", deserializedFishV2.getName(), deserializedFishV2.getAge(), deserializedFishV2.getLengthMeters(), deserializedFishV2.getWeightTons());
    }
}
