package com.sensiblemetrics.api.alpenidos.core.execute_around.iface;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Interface for specifying what to do with the file resource.
 */
@FunctionalInterface
public interface FileWriterAction {

    void writeFile(final FileWriter writer) throws IOException;
}
