package com.sensiblemetrics.api.alpenidos.pattern.command.model;

import com.sensiblemetrics.api.alpenidos.pattern.command.iface.TextFileOperation;
import com.sensiblemetrics.api.alpenidos.pattern.command.receiver.TextFile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveTextFileOperation implements TextFileOperation {

    private final TextFile textFile;

    @Override
    public String execute() {
        return textFile.save();
    }
}
