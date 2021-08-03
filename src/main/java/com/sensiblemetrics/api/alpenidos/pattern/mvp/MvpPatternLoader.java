package com.sensiblemetrics.api.alpenidos.pattern.mvp;

import com.sensiblemetrics.api.alpenidos.pattern.mvp.frame.FileSelectorJFrame;
import com.sensiblemetrics.api.alpenidos.pattern.mvp.model.FileLoader;
import com.sensiblemetrics.api.alpenidos.pattern.mvp.presenter.FileSelectorPresenter;

/**
 * The Model-View-Presenter(MVP) architectural pattern, helps us achieve what is called
 * "The separation of concerns" principle. This is accomplished by separating the application's
 * logic (Model), GUIs (View), and finally the way that the user's actions update the application's
 * logic (Presenter).
 * <p>
 * In the following example, The {@link FileLoader} class represents the app's logic, the
 * {@link FileSelectorJFrame} is the GUI and the {@link FileSelectorPresenter} is responsible to
 * respond to users' actions.
 * <p>
 * Finally, please notice the wiring between the Presenter and the View and between the Presenter
 * and the Model.
 */
public class MvpPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final FileLoader loader = new FileLoader();
        final FileSelectorJFrame jFrame = new FileSelectorJFrame();
        final FileSelectorPresenter presenter = new FileSelectorPresenter(jFrame);
        presenter.setLoader(loader);
        presenter.start();
    }
}
