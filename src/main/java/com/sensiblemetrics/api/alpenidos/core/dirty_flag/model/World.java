package com.sensiblemetrics.api.alpenidos.core.dirty_flag.model;

import com.sensiblemetrics.api.alpenidos.core.dirty_flag.impl.DataFetcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A middle-layer app that calls/passes along data from the back-end.
 *
 * @author swaisuan
 */
public class World {
    private List<String> countries;
    private DataFetcher df;

    public World() {
        this.countries = new ArrayList<>();
        this.df = new DataFetcher();
    }

    /**
     * Calls {@link DataFetcher} to fetch data from back-end.
     *
     * @return List of strings
     */
    public List<String> fetch() {
        return Optional.ofNullable(this.df.fetch()).orElse(this.countries);
    }
}
