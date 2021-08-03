package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.PlayerDetails;
import lombok.Data;
import org.bson.Document;

/**
 * Mongo based event log
 */
@Data
public class MongoEventLog implements LotteryEventLog {
    private static final String DEFAULT_DB = "lotteryDB";
    private static final String DEFAULT_EVENTS_COLLECTION = "events";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> eventsCollection;

    private StdOutEventLog stdOutEventLog = new StdOutEventLog();

    /**
     * Constructor
     */
    public MongoEventLog() {
        this.connect();
    }

    /**
     * Constructor accepting parameters
     */
    public MongoEventLog(final String dbName, final String eventsCollectionName) {
        this.connect(dbName, eventsCollectionName);
    }

    /**
     * Connect to database with default parameters
     */
    public void connect() {
        this.connect(DEFAULT_DB, DEFAULT_EVENTS_COLLECTION);
    }

    /**
     * Connect to database with given parameters
     */
    public void connect(final String dbName, final String eventsCollectionName) {
        if (this.mongoClient != null) {
            this.mongoClient.close();
        }
        this.mongoClient = new MongoClient(System.getProperty("mongo-host"), Integer.parseInt(System.getProperty("mongo-port")));
        this.database = this.mongoClient.getDatabase(dbName);
        this.eventsCollection = this.database.getCollection(eventsCollectionName);
    }

    @Override
    public void ticketSubmitted(final PlayerDetails details) {
        final Document document = new Document("email", details.getEmail());
        document.put("phone", details.getPhoneNumber());
        document.put("bank", details.getBankAccount());
        document.put("message", "Lottery ticket was submitted and bank account was charged for 3 credits.");
        this.eventsCollection.insertOne(document);
        this.stdOutEventLog.ticketSubmitted(details);
    }

    @Override
    public void ticketSubmitError(PlayerDetails details) {
        final Document document = new Document("email", details.getEmail());
        document.put("phone", details.getPhoneNumber());
        document.put("bank", details.getBankAccount());
        document.put("message", "Lottery ticket could not be submitted because lack of funds.");
        this.eventsCollection.insertOne(document);
        this.stdOutEventLog.ticketSubmitError(details);
    }

    @Override
    public void ticketDidNotWin(PlayerDetails details) {
        final Document document = new Document("email", details.getEmail());
        document.put("phone", details.getPhoneNumber());
        document.put("bank", details.getBankAccount());
        document.put("message", "Lottery ticket was checked and unfortunately did not win this time.");
        this.eventsCollection.insertOne(document);
        this.stdOutEventLog.ticketDidNotWin(details);
    }

    @Override
    public void ticketWon(PlayerDetails details, int prizeAmount) {
        final Document document = new Document("email", details.getEmail());
        document.put("phone", details.getPhoneNumber());
        document.put("bank", details.getBankAccount());
        document.put("message", String.format("Lottery ticket won! The bank account was deposited with %d credits.", prizeAmount));
        this.eventsCollection.insertOne(document);
        this.stdOutEventLog.ticketWon(details, prizeAmount);
    }

    @Override
    public void prizeError(PlayerDetails details, int prizeAmount) {
        final Document document = new Document("email", details.getEmail());
        document.put("phone", details.getPhoneNumber());
        document.put("bank", details.getBankAccount());
        document.put("message", String.format("Lottery ticket won! Unfortunately the bank credit transfer of %d failed.", prizeAmount));
        this.eventsCollection.insertOne(document);
        this.stdOutEventLog.prizeError(details, prizeAmount);
    }
}
