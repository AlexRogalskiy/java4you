package com.sensiblemetrics.api.alpenidos.pattern.event.queue.impl;

import com.sensiblemetrics.api.alpenidos.pattern.event.queue.model.PlayMessage;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class implements the Event Queue pattern.
 */
@Slf4j
@NoArgsConstructor
public class Audio {
    private static final Audio INSTANCE = new Audio();

    private static final int MAX_PENDING = 16;

    private int headIndex;
    private int tailIndex;
    private volatile Thread updateThread = null;

    private PlayMessage[] pendingAudio = new PlayMessage[MAX_PENDING];

    public static Audio getInstance() {
        return INSTANCE;
    }

    /**
     * This method stops the Update Method's thread and waits till service stops.
     */
    public synchronized void stopService() throws InterruptedException {
        if (this.updateThread != null) {
            this.updateThread.interrupt();
        }
        this.updateThread.join();
        this.updateThread = null;
    }

    /**
     * This method check the Update Method's thread is started.
     *
     * @return boolean
     */
    public synchronized boolean isServiceRunning() {
        return this.updateThread != null && this.updateThread.isAlive();
    }

    /**
     * Starts the thread for the Update Method pattern if it was not started previously.
     * Also when the thread is is ready initializes the indexes of the queue
     */
    public void init() {
        if (this.updateThread == null) {
            this.updateThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    this.update();
                }
            });
        }
        this.startThread();
    }

    /**
     * This is a synchronized thread starter
     */
    private synchronized void startThread() {
        if (!this.updateThread.isAlive()) {
            this.updateThread.start();
            this.headIndex = 0;
            this.tailIndex = 0;
        }
    }

    /**
     * This method adds a new audio into the queue.
     *
     * @param stream is the AudioInputStream for the method
     * @param volume is the level of the audio's volume
     */
    public void playSound(final AudioInputStream stream, final float volume) {
        init();
        // Walk the pending requests.
        for (int i = this.headIndex; i != this.tailIndex; i = (i + 1) % MAX_PENDING) {
            if (getPendingAudio()[i].getStream() == stream) {
                // Use the larger of the two volumes.
                getPendingAudio()[i].setVolume(Math.max(volume, getPendingAudio()[i].getVolume()));

                // Don't need to enqueue.
                return;
            }
        }
        this.getPendingAudio()[this.tailIndex] = new PlayMessage(stream, volume);
        this.tailIndex = (this.tailIndex + 1) % MAX_PENDING;
    }

    /**
     * This method uses the Update Method pattern.
     * It takes the audio from the queue and plays it
     */
    private void update() {
        // If there are no pending requests, do nothing.
        if (this.headIndex == this.tailIndex) {
            return;
        }
        Clip clip = null;
        try {
            final AudioInputStream audioStream = getPendingAudio()[headIndex].getStream();
            this.headIndex++;
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (LineUnavailableException e) {
            log.trace("Error occurred while loading the audio: The line is unavailable", e);
        } catch (IOException e) {
            log.trace("Input/Output error while loading the audio", e);
        } catch (IllegalArgumentException e) {
            log.trace("The system doesn't support the sound: " + e.getMessage(), e);
        }
    }

    /**
     * Returns the AudioInputStream of a file
     *
     * @param filePath is the path of the audio file
     * @return AudioInputStream
     * @throws UnsupportedAudioFileException when the audio file is not supported
     * @throws IOException                   when the file is not readable
     */
    public AudioInputStream getAudioStream(final String filePath) throws UnsupportedAudioFileException, IOException {
        return AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
    }

    /**
     * Returns with the message array of the queue
     *
     * @return PlayMessage[]
     */
    public PlayMessage[] getPendingAudio() {
        return this.pendingAudio;
    }
}
