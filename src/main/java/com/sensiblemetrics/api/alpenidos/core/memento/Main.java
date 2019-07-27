package com.sensiblemetrics.api.alpenidos.core.memento;

public class Main {
    public static void main(String[] args) {
        final Caretaker caretaker = new Caretaker();

        final Originator originator = new Originator();
        originator.set("A");
        originator.set("B");
        caretaker.add(originator.saveToMemento());
        originator.set("C");
        caretaker.add(originator.saveToMemento());
        originator.set("D");

        originator.restoreFromMemento(caretaker.get(1));
        originator.restoreFromMemento(caretaker.get(0));
    }
}
