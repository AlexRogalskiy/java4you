package com.sensiblemetrics.api.alpenidos.pattern.mediator4.components;

import com.sensiblemetrics.api.alpenidos.pattern.mediator4.management.Mediator;
import com.sensiblemetrics.api.alpenidos.pattern.mediator4.model.Note;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 * EN: Concrete components don't talk with each other. They have only one communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только один канал общения – через отправку уведомлений посреднику.
 */
public class Filter extends JTextField implements Component {

    private Mediator mediator;
    private ListModel listModel;

    public Filter() {
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add((Note) listModel.getElementAt(i));
        }
        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
