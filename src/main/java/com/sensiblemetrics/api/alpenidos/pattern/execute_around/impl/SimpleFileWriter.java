package com.sensiblemetrics.api.alpenidos.pattern.execute_around.impl;

import com.sensiblemetrics.api.alpenidos.pattern.execute_around.iface.FileWriterAction;

import java.io.FileWriter;
import java.io.IOException;

/**
 * SimpleFileWriter handles opening and closing file for the user. The user only has to specify what
 * to do with the file resource through {@link FileWriterAction} parameter.
 */
public class SimpleFileWriter {

    /**
     * Constructor
     */
    public SimpleFileWriter(final String filename, final FileWriterAction action) throws IOException {
        try (final FileWriter writer = new FileWriter(filename)) {
            action.writeFile(writer);
        }
    }
}
