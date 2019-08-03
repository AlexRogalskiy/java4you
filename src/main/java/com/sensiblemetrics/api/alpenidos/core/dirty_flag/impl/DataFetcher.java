package com.sensiblemetrics.api.alpenidos.core.dirty_flag.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * A mock database manager -- Fetches data from a raw file.
 *
 * @author swaisuan
 */
@Slf4j
public class DataFetcher {
    private final String filename = "world.txt";
    private long lastFetched;

    public DataFetcher() {
        this.lastFetched = -1;
    }

    private boolean isDirty(final long fileLastModified) {
        if (this.lastFetched != fileLastModified) {
            this.lastFetched = fileLastModified;
            return true;
        }
        return false;
    }

    /**
     * Fetches data/content from raw file.
     *
     * @return List of strings
     */
    public List<String> fetch() {
        final ClassLoader classLoader = getClass().getClassLoader();
        final File file = new File(classLoader.getResource(filename).getFile());
        if (this.isDirty(file.lastModified())) {
            log.debug(filename + " is dirty! Re-fetching file content...");
            try {
                return FileUtils.readLines(file, StandardCharsets.UTF_8.name());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }
}
