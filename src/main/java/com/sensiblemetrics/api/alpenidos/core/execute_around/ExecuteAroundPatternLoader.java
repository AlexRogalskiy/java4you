package com.sensiblemetrics.api.alpenidos.core.execute_around;

import com.sensiblemetrics.api.alpenidos.core.execute_around.iface.FileWriterAction;
import com.sensiblemetrics.api.alpenidos.core.execute_around.impl.SimpleFileWriter;

import java.io.IOException;

/**
 * The Execute Around idiom specifies some code to be executed before and after a method. Typically
 * the idiom is used when the API has methods to be executed in pairs, such as resource
 * allocation/deallocation or lock acquisition/release.
 * <p>
 * In this example, we have {@link SimpleFileWriter} class that opens and closes the file for the
 * user. The user specifies only what to do with the file by providing the {@link FileWriterAction}
 * implementation.
 */
public class ExecuteAroundPatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) throws IOException {
        final FileWriterAction writeHello = writer -> {
            writer.write("Hello");
            writer.append(" ");
            writer.append("there!");
        };
        new SimpleFileWriter("testfile.txt", writeHello);
    }
}
