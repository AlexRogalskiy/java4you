package com.sensiblemetrics.api.alpenidos.pattern.command;

import com.sensiblemetrics.api.alpenidos.pattern.command.model.OpenTextFileOperation;
import com.sensiblemetrics.api.alpenidos.pattern.command.model.SaveTextFileOperation;
import com.sensiblemetrics.api.alpenidos.pattern.command.iface.TextFileOperation;
import com.sensiblemetrics.api.alpenidos.pattern.command.invoker.TextFileOperationExecutor;
import com.sensiblemetrics.api.alpenidos.pattern.command.receiver.TextFile;

public class CommandPatternLoader {

    public static void main(final String[] args) {
        final TextFileOperation openTextFileOperation = new OpenTextFileOperation(TextFile.of("file1.txt"));
        final TextFileOperation saveTextFileOperation = new SaveTextFileOperation(TextFile.of("file2.txt"));
        final TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        System.out.println(textFileOperationExecutor.executeOperation(openTextFileOperation));
        System.out.println(textFileOperationExecutor.executeOperation(saveTextFileOperation));
    }
}
