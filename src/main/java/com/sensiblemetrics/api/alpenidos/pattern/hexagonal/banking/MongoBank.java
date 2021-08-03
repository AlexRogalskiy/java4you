package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Mongo based banking adapter
 */
@Getter
public class MongoBank implements WireTransfers {
    private static final String DEFAULT_DB = "lotteryDB";
    private static final String DEFAULT_ACCOUNTS_COLLECTION = "accounts";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> accountsCollection;

    /**
     * Constructor
     */
    public MongoBank() {
        this.connect();
    }

    /**
     * Constructor accepting parameters
     */
    public MongoBank(final String dbName, final String accountsCollectionName) {
        this.connect(dbName, accountsCollectionName);
    }

    /**
     * Connect to database with default parameters
     */
    public void connect() {
        this.connect(DEFAULT_DB, DEFAULT_ACCOUNTS_COLLECTION);
    }

    /**
     * Connect to database with given parameters
     */
    public void connect(final String dbName, final String accountsCollectionName) {
        if (this.mongoClient != null) {
            this.mongoClient.close();
        }
        this.mongoClient = new MongoClient(System.getProperty("mongo-host"), Integer.parseInt(System.getProperty("mongo-port")));
        this.database = this.mongoClient.getDatabase(dbName);
        this.accountsCollection = this.database.getCollection(accountsCollectionName);
    }

    @Override
    public void setFunds(final String bankAccount, final int amount) {
        final Document search = new Document("_id", bankAccount);
        final Document update = new Document("_id", bankAccount).append("funds", amount);
        this.accountsCollection.updateOne(search, new Document("$set", update), new UpdateOptions().upsert(true));
    }

    @Override
    public int getFunds(final String bankAccount) {
        final Document search = new Document("_id", bankAccount);
        final List<Document> results = this.accountsCollection.find(search).limit(1).into(new ArrayList<>());
        if (results.size() > 0) {
            return results.get(0).getInteger("funds");
        }
        return 0;
    }

    @Override
    public boolean transferFunds(final int amount, final String sourceBackAccount, final String destinationBankAccount) {
        final int sourceFunds = this.getFunds(sourceBackAccount);
        if (sourceFunds < amount) {
            return false;
        }
        final int destFunds = this.getFunds(destinationBankAccount);
        this.setFunds(sourceBackAccount, sourceFunds - amount);
        this.setFunds(destinationBankAccount, destFunds + amount);
        return true;
    }
}
