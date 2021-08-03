package com.sensiblemetrics.api.alpenidos.pattern.memento5.history;

import com.sensiblemetrics.api.alpenidos.pattern.memento5.editor.Editor;

public class Memento {

    private final String backup;
    private final Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
