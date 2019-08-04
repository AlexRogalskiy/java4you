package com.sensiblemetrics.api.alpenidos.core.event.queue.model;

import lombok.Data;

import javax.sound.sampled.AudioInputStream;

/**
 * The Event Queue's queue will store the instances of this class.
 */
@Data
public class PlayMessage {
    private AudioInputStream stream;
    private float volume;

    public PlayMessage(final AudioInputStream stream, final float volume) {
        this.setStream(stream);
        this.setVolume(volume);
    }
}
