package com.sensiblemetrics.api.alpenidos.pattern.command.invoker;

import com.sensiblemetrics.api.alpenidos.pattern.command.iface.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(final TextFileOperation textFileOperation) {
        this.textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
