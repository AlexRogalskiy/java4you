package com.sensiblemetrics.api.alpenidos.core.command.model;

import com.sensiblemetrics.api.alpenidos.core.command.iface.TextFileOperation;
import com.sensiblemetrics.api.alpenidos.core.command.receiver.TextFile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveTextFileOperation implements TextFileOperation {

    private final TextFile textFile;

    @Override
    public String execute() {
        return textFile.save();
    }
}
