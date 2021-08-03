package com.sensiblemetrics.api.alpenidos.pattern.mvp.model;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

/**
 * Every instance of this class represents the Model component in the Model-View-Presenter
 * architectural pattern.
 * <p>
 * It is responsible for reading and loading the contents of a given file.
 */
@Slf4j
public class FileLoader implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 2480583955696638744L;

    /**
     * Indicates if the file is loaded or not.
     */
    private boolean loaded;

    /**
     * The name of the file that we want to load.
     */
    private String fileName;

    /**
     * Loads the data of the file specified.
     */
    public String loadData() {
        final String dataFileName = this.fileName;
        try (final BufferedReader br = new BufferedReader(new FileReader(new File(dataFileName)))) {
            final StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            this.loaded = true;
            return sb.toString();
        } catch (Exception e) {
            log.error("File {} does not exist", dataFileName);
        }
        return null;
    }

    /**
     * Sets the path of the file to be loaded, to the given value.
     *
     * @param fileName The path of the file to be loaded.
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return fileName The path of the file to be loaded.
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * @return True, if the file given exists, false otherwise.
     */
    public boolean fileExists() {
        return new File(this.fileName).exists();
    }

    /**
     * @return True, if the file is loaded, false otherwise.
     */
    public boolean isLoaded() {
        return this.loaded;
    }
}
