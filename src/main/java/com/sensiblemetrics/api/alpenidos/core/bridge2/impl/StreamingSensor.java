package com.sensiblemetrics.api.alpenidos.core.bridge2.impl;

import com.sensiblemetrics.api.alpenidos.core.bridge2.exception.SensorException;
import com.sensiblemetrics.api.alpenidos.core.bridge2.iface.StreamingSensorIF;
import com.sensiblemetrics.api.alpenidos.core.bridge2.iface.StreamingSensorListener;

import java.io.*;
import java.util.Vector;

public class StreamingSensor extends SimpleSensor implements StreamingSensorListener, Runnable {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private final Vector<StreamingSensorListener> listeners = new Vector<>();

    public StreamingSensor(final StreamingSensorIF sensor) throws SensorException {
        super(sensor);
        final PipedInputStream pipedInputStream = new PipedInputStream();
        this.dataInputStream = new DataInputStream(pipedInputStream);
        PipedOutputStream pipedOutputStream;
        try {
            pipedOutputStream = new PipedOutputStream(pipedInputStream);
        } catch (IOException e) {
            throw new SensorException();
        }
        this.dataOutputStream = new DataOutputStream(pipedOutputStream);
        new Thread(this).start();
    }

    public void setSamplingFrequency(final int frequency) throws SensorException {
        final StreamingSensorIF sensorIF = (StreamingSensorIF) this.getSensorIF();
        sensorIF.setSamplingFrequency(frequency);
    }

    public void processMeasurement(final int value) {
        try {
            this.dataOutputStream.writeInt(value);
        } catch (IOException e) {
        }
    }

    public void addStreamingSensorListener(final StreamingSensorListener listener) {
        this.listeners.add(listener);
    }

    public void removeStreamingSensorListener(final StreamingSensorListener listener) {
        this.listeners.removeElement(listener);
    }

    @Override
    public void run() {
        while (true) {
            try {
                final int value = this.dataInputStream.readInt();
                this.listeners.forEach(l -> l.processMeasurement(value));
            } catch (IOException e) {
            }
        }
    }
}
