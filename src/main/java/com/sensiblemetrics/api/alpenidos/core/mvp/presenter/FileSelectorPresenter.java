package com.sensiblemetrics.api.alpenidos.core.mvp.presenter;

import com.sensiblemetrics.api.alpenidos.core.mvp.model.FileLoader;
import com.sensiblemetrics.api.alpenidos.core.mvp.iface.FileSelectorView;

import java.io.Serializable;

/**
 * Every instance of this class represents the Presenter component in the Model-View-Presenter
 * architectural pattern.
 * <p>
 * It is responsible for reacting to the user's actions and update the View component.
 */
public class FileSelectorPresenter implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 1966445553287011029L;

    /**
     * The View component that the presenter interacts with.
     */
    private FileSelectorView view;

    /**
     * The Model component that the presenter interacts with.
     */
    private FileLoader loader;

    /**
     * Constructor
     *
     * @param view The view component that the presenter will interact with.
     */
    public FileSelectorPresenter(final FileSelectorView view) {
        this.view = view;
    }

    /**
     * Sets the {@link FileLoader} object, to the value given as parameter.
     *
     * @param loader The new {@link FileLoader} object(the Model component).
     */
    public void setLoader(final FileLoader loader) {
        this.loader = loader;
    }

    /**
     * Starts the presenter.
     */
    public void start() {
        this.view.setPresenter(this);
        this.view.open();
    }

    /**
     * An "event" that fires when the name of the file to be loaded changes.
     */
    public void fileNameChanged() {
        this.loader.setFileName(this.view.getFileName());
    }

    /**
     * Ok button handler
     */
    public void confirmed() {
        if (loader.getFileName() == null || loader.getFileName().equals("")) {
            this.view.showMessage("Please give the name of the file first!");
            return;
        }
        if (loader.fileExists()) {
            final String data = loader.loadData();
            this.view.displayData(data);
        } else {
            this.view.showMessage("The file specified does not exist.");
        }
    }

    /**
     * Cancels the file loading process.
     */
    public void cancelled() {
        this.view.close();
    }
}
