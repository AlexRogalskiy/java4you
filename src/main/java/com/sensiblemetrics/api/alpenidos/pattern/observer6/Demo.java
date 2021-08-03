package com.sensiblemetrics.api.alpenidos.pattern.observer6;

import com.sensiblemetrics.api.alpenidos.pattern.observer6.editor.Editor;
import com.sensiblemetrics.api.alpenidos.pattern.observer6.listeners.EmailNotificationListener;
import com.sensiblemetrics.api.alpenidos.pattern.observer6.listeners.LogOpenListener;

public class Demo {

    public static void main(final String[] args) {
        final Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
