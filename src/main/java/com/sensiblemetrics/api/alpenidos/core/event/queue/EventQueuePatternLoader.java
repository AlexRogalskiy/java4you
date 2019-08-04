package com.sensiblemetrics.api.alpenidos.core.event.queue;

import com.sensiblemetrics.api.alpenidos.core.event.queue.impl.Audio;
import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Event or message queues provide an asynchronous communications protocol, meaning that the sender
 * and receiver of the message do not need to interact with the message queue at the same time.
 * Events or messages placed onto the queue are stored until the recipient retrieves them. Event
 * or message queues have implicit or explicit limits on the size of data that may be transmitted
 * in a single message and the number of messages that may remain outstanding on the queue.
 * A queue stores a series of notifications or requests in first-in, first-out order.
 * Sending a notification enqueues the request and returns. The request processor then processes
 * items from the queue at a later time.
 */
@Slf4j
public class EventQueuePatternLoader {
    /**
     * Program entry point.
     *
     * @param args command line args
     * @throws IOException                   when there is a problem with the audio file loading
     * @throws UnsupportedAudioFileException when the loaded audio file is unsupported
     */
    public static void main(final String[] args) throws UnsupportedAudioFileException, IOException, InterruptedException {
        final Audio audio = Audio.getInstance();
        audio.playSound(audio.getAudioStream("./etc/Bass-Drum-1.wav"), -10.0f);
        audio.playSound(audio.getAudioStream("./etc/Closed-Hi-Hat-1.wav"), -8.0f);

        log.debug("Press Enter key to stop the program...");
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.read();
        }
        audio.stopService();
    }
}
