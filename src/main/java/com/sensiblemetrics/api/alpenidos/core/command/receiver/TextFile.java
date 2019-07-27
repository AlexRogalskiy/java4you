package com.sensiblemetrics.api.alpenidos.core.command.receiver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TextFile {

    private final String name;

    public String open() {
        return String.format("Opening file {%s}", this.name);
    }

    public String read() {
        return String.format("Reading file {%s}", this.name);
    }

    public String write() {
        return String.format("Writing to file {%s}", this.name);
    }

    public String save() {
        return String.format("Saving file {%s}", this.name);
    }

    public String copy() {
        return String.format("Copying file {%s}", this.name);
    }

    public String paste() {
        return String.format("Pasting file {%s}", this.name);
    }

    public static TextFile of(final String fileName) {
        return new TextFile(fileName);
    }
}
