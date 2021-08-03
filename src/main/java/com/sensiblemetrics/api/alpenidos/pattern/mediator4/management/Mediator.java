package com.sensiblemetrics.api.alpenidos.pattern.mediator4.management;

import com.sensiblemetrics.api.alpenidos.pattern.mediator4.components.Component;
import com.sensiblemetrics.api.alpenidos.pattern.mediator4.model.Note;
import javax.swing.ListModel;

/**
 * EN: Common mediator interface.
 * <p>
 * RU: Общий интерфейс посредников.
 */
public interface Mediator {

    void addNewNote(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void sendToFilter(ListModel listModel);

    void setElementsList(ListModel list);

    void registerComponent(Component component);

    void hideElements(boolean flag);

    void createGUI();
}
