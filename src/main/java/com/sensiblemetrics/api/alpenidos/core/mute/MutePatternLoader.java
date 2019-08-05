package com.sensiblemetrics.api.alpenidos.core.mute;

import com.sensiblemetrics.api.alpenidos.core.mute.iface.Resource;
import com.sensiblemetrics.api.alpenidos.core.mute.impl.Mute;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Mute pattern is utilized when we need to suppress an exception due to an API flaw or in
 * situation when all we can do to handle the exception is to log it.
 * This pattern should not be used everywhere. It is very important to logically handle the
 * exceptions in a system, but some situations like the ones described above require this pattern,
 * so that we don't need to repeat
 * <pre>
 * <code>
 *   try {
 *     // code that may throwing exception we need to ignore or may never be thrown
 *   } catch (Exception ex) {
 *     // ignore by logging or throw error if unexpected exception occurs
 *   }
 * </code>
 * </pre> every time we need to ignore an exception.
 */
@Slf4j
public class MutePatternLoader {

    /**
     * Program entry point.
     *
     * @param args command line args.
     * @throws Exception if any exception occurs
     */
    public static void main(final String[] args) throws Exception {
        useOfLoggedMute();
        useOfMute();
    }

    /*
     * Typically used when the API declares some exception but cannot do so. Usually a
     * signature mistake.In this example out is not supposed to throw exception as it is a
     * ByteArrayOutputStream. So we utilize mute, which will throw AssertionError if unexpected
     * exception occurs.
     */
    private static void useOfMute() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        Mute.mute(() -> out.write("Hello".getBytes()));
    }

    private static void useOfLoggedMute() throws SQLException {
        Resource resource = null;
        try {
            resource = acquireResource();
            utilizeResource(resource);
        } finally {
            closeResource(resource);
        }
    }

    /*
     * All we can do while failed close of a resource is to log it.
     */
    private static void closeResource(final Resource resource) {
        Mute.loggedMute(() -> resource.close());
    }

    private static void utilizeResource(final Resource resource) {
        log.info("Utilizing acquired resource: {}", resource);
    }

    private static Resource acquireResource() {
        return new Resource() {
            @Override
            public void close() throws IOException {
                throw new IOException("Error in closing resource: " + this);
            }
        };
    }
}
