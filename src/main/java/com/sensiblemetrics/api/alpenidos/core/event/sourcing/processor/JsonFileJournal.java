package com.sensiblemetrics.api.alpenidos.core.event.sourcing.processor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.AccountCreateEvent;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.DomainEvent;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.MoneyDepositEvent;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.MoneyTransferEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the implementation of event journal.
 * This implementation serialize/deserialize the events with JSON
 * and writes/reads them on a Journal.json file at the working directory.
 */
public class JsonFileJournal {
    private final File aFile;
    private final List<String> events = new ArrayList<>();
    private int index = 0;

    /**
     * Instantiates a new Json file journal.
     */
    public JsonFileJournal() {
        this.aFile = new File("Journal.json");
        if (this.aFile.exists()) {
            try (final BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(aFile), "UTF-8"))) {
                String line;
                while ((line = input.readLine()) != null) {
                    this.events.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.reset();
        }
    }

    /**
     * Write.
     *
     * @param domainEvent the domain event
     */
    public void write(final DomainEvent domainEvent) {
        final Gson gson = new Gson();
        JsonElement jsonElement;
        if (domainEvent instanceof AccountCreateEvent) {
            jsonElement = gson.toJsonTree(domainEvent, AccountCreateEvent.class);
        } else if (domainEvent instanceof MoneyDepositEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyDepositEvent.class);
        } else if (domainEvent instanceof MoneyTransferEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyTransferEvent.class);
        } else {
            throw new RuntimeException("Journal Event not recegnized");
        }

        try (final Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aFile, true), "UTF-8"))) {
            final String eventString = jsonElement.toString();
            output.write(eventString + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reset.
     */
    public void reset() {
        this.aFile.delete();
    }

    /**
     * Read next domain event.
     *
     * @return the domain event
     */
    public DomainEvent readNext() {
        if (this.index >= this.events.size()) {
            return null;
        }
        final String event = this.events.get(this.index);
        this.index++;

        final JsonParser parser = new JsonParser();
        final JsonElement jsonElement = parser.parse(event);
        final String eventClassName = jsonElement.getAsJsonObject().get("eventClassName").getAsString();
        final Gson gson = new Gson();

        DomainEvent domainEvent;
        if (eventClassName.equals("AccountCreateEvent")) {
            domainEvent = gson.fromJson(jsonElement, AccountCreateEvent.class);
        } else if (eventClassName.equals("MoneyDepositEvent")) {
            domainEvent = gson.fromJson(jsonElement, MoneyDepositEvent.class);
        } else if (eventClassName.equals("MoneyTransferEvent")) {
            domainEvent = gson.fromJson(jsonElement, MoneyTransferEvent.class);
        } else {
            throw new RuntimeException("Journal Event not recegnized");
        }
        domainEvent.setRealTime(false);
        return domainEvent;
    }
}
