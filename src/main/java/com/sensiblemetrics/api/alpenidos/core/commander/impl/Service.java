package com.sensiblemetrics.api.alpenidos.core.commander.impl;

import com.sensiblemetrics.api.alpenidos.core.commander.exception.DatabaseUnavailableException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

/**
 * Service class is an abstract class extended by all services in this example. They
 * all have a public receiveRequest method to receive requests, which could also contain
 * details of the user other than the implementation details (though we are not doing
 * that here) and updateDb method which adds to their respective databases. There is a
 * method to generate transaction/request id for the transactions/requests, which are
 * then sent back. These could be stored by the {@link Commander} class in a separate
 * database for reference (though we are not doing that here).
 */
public abstract class Service {
    protected final Database database;
    public ArrayList<Exception> exceptionsList;
    private static final String ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final Hashtable<String, Boolean> USED_IDS = new Hashtable<String, Boolean>();

    protected Service(final Database db, final Exception... exc) {
        this.database = db;
        this.exceptionsList = new ArrayList<Exception>(Arrays.asList(exc));
    }

    public abstract String receiveRequest(final Object... parameters) throws DatabaseUnavailableException;

    protected abstract String updateDb(final Object... parameters) throws DatabaseUnavailableException;

    protected String generateId() {
        final StringBuilder random = new StringBuilder();
        final Random rand = new Random();
        while (random.length() < 12) { // length of the random string.
            int index = (int) (rand.nextFloat() * ALL_CHARS.length());
            random.append(ALL_CHARS.charAt(index));
        }
        String id = random.toString();
        if (USED_IDS.get(id) != null) {
            while (USED_IDS.get(id)) {
                id = generateId();
            }
        }
        return id;
    }
}
