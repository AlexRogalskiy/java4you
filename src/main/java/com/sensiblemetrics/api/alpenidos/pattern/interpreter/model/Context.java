package com.sensiblemetrics.api.alpenidos.pattern.interpreter.model;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter.iface.Expression;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class Context {

    private static Map<String, List<Row>> tables = new HashMap<>();

    static {
        final List<Row> list = new ArrayList<>();
        list.add(new Row("John", "Doe"));
        list.add(new Row("Jan", "Kowalski"));
        list.add(new Row("Dominic", "Doom"));
        tables.put("people", list);
    }

    private String table;
    private String column;

    /**
     * Index of column to be shown in result.
     * Calculated in {@link #setColumnMapper()}
     */
    private int colIndex = -1;

    /**
     * Default setup, used for clearing the context for next queries.
     * See {@link Context#clear()}
     */
    private static final Predicate<String> matchAnyString = s -> s.length() > 0;
    private static final Function<String, Stream<? extends String>> matchAllColumns = Stream::of;
    /**
     * Varies based on setup in subclasses of {@link Expression}
     */
    private Predicate<String> whereFilter = matchAnyString;
    private Function<String, Stream<? extends String>> columnMapper = matchAllColumns;

    public void setColumn(final String column) {
        this.column = column;
        this.setColumnMapper();
    }

    public void setTable(final String table) {
        this.table = table;
    }

    public void setFilter(final Predicate<String> filter) {
        this.whereFilter = filter;
    }

    /**
     * Clears the context to defaults.
     * No filters, match all columns.
     */
    public void clear() {
        this.column = StringUtils.EMPTY;
        this.columnMapper = matchAllColumns;
        this.whereFilter = matchAnyString;
    }

    public List<String> search() {
        final List<String> result = tables.entrySet()
            .stream()
            .filter(entry -> entry.getKey().equalsIgnoreCase(table))
            .flatMap(entry -> Stream.of(entry.getValue()))
            .flatMap(Collection::stream)
            .map(Row::toString)
            .flatMap(this.columnMapper)
            .filter(this.whereFilter)
            .collect(Collectors.toList());
        this.clear();
        return result;
    }

    /**
     * Sets column mapper based on {@link #column} attribute.
     * Note: If column is unknown, will remain to look for all columns.
     */
    private void setColumnMapper() {
        switch (this.column) {
            case "*":
                this.colIndex = -1;
                break;
            case "name":
                this.colIndex = 0;
                break;
            case "surname":
                this.colIndex = 1;
                break;
        }
        if (this.colIndex != -1) {
            this.columnMapper = s -> Stream.of(s.split(SPACE)[this.colIndex]);
        }
    }
}
