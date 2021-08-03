package com.sensiblemetrics.api.alpenidos.pattern.maze;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@UtilityClass
public class Utils {
    /**
     * Default file character encoding
     */
    public static final Charset DEFAULT_FILE_CHARACTER_ENCODING = StandardCharsets.UTF_8;

    public static <U extends CharSequence> List<U> readAllLines(final File inputFile) {
        Objects.requireNonNull(inputFile);
        List<U> resultList = Collections.EMPTY_LIST;
        try {
            resultList = (List<U>) Files.readAllLines(inputFile.toPath(), DEFAULT_FILE_CHARACTER_ENCODING);
        } catch (IOException ex) {
            log.error(String.format("ERROR: cannot read from input file=%s, message=%s", String.valueOf(inputFile), ex.getMessage()));
        }
        return resultList;
    }
}
