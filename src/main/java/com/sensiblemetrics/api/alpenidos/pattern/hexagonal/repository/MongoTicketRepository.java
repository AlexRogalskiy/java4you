package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryNumbers;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryTicket;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryTicketId;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.PlayerDetails;
import org.bson.Document;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mongo lottery ticket database
 */
public class MongoTicketRepository implements LotteryTicketRepository {
    private static final String DEFAULT_DB = "lotteryDB";
    private static final String DEFAULT_TICKETS_COLLECTION = "lotteryTickets";
    private static final String DEFAULT_COUNTERS_COLLECTION = "counters";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> ticketsCollection;
    private MongoCollection<Document> countersCollection;

    /**
     * Constructor
     */
    public MongoTicketRepository() {
        this.connect();
    }

    /**
     * Constructor accepting parameters
     */
    public MongoTicketRepository(final String dbName, final String ticketsCollectionName, final String countersCollectionName) {
        this.connect(dbName, ticketsCollectionName, countersCollectionName);
    }

    /**
     * Connect to database with default parameters
     */
    public void connect() {
        this.connect(DEFAULT_DB, DEFAULT_TICKETS_COLLECTION, DEFAULT_COUNTERS_COLLECTION);
    }

    /**
     * Connect to database with given parameters
     */
    public void connect(final String dbName, final String ticketsCollectionName, final String countersCollectionName) {
        if (this.mongoClient != null) {
            this.mongoClient.close();
        }
        this.mongoClient = new MongoClient(System.getProperty("mongo-host"), Integer.parseInt(System.getProperty("mongo-port")));
        this.database = mongoClient.getDatabase(dbName);
        this.ticketsCollection = database.getCollection(ticketsCollectionName);
        this.countersCollection = database.getCollection(countersCollectionName);
        if (this.countersCollection.countDocuments() <= 0) {
            this.initCounters();
        }
    }

    private void initCounters() {
        final Document doc = new Document("_id", "ticketId").append("seq", 1);
        this.countersCollection.insertOne(doc);
    }

    /**
     * @return next ticket id
     */
    public int getNextId() {
        final Document find = new Document("_id", "ticketId");
        final Document increase = new Document("seq", 1);
        final Document update = new Document("$inc", increase);
        final Document result = this.countersCollection.findOneAndUpdate(find, update);
        return result.getInteger("seq");
    }

    /**
     * @return tickets collection
     */
    public MongoCollection<Document> getTicketsCollection() {
        return this.ticketsCollection;
    }

    /**
     * @return counters collection
     */
    public MongoCollection<Document> getCountersCollection() {
        return this.countersCollection;
    }

    @Override
    public Optional<LotteryTicket> findById(final LotteryTicketId id) {
        final Document find = new Document("ticketId", id.getId());
        final List<Document> results = ticketsCollection.find(find).limit(1).into(new ArrayList<>());
        if (results.size() > 0) {
            final LotteryTicket lotteryTicket = this.docToTicket(results.get(0));
            return Optional.of(lotteryTicket);
        }
        return Optional.empty();
    }

    @Override
    public Optional<LotteryTicketId> save(final LotteryTicket ticket) {
        final int ticketId = getNextId();
        final Document doc = new Document("ticketId", ticketId);
        doc.put("email", ticket.getPlayerDetails().getEmail());
        doc.put("bank", ticket.getPlayerDetails().getBankAccount());
        doc.put("phone", ticket.getPlayerDetails().getPhoneNumber());
        doc.put("numbers", ticket.getNumbers().getNumbersAsString());

        this.ticketsCollection.insertOne(doc);
        return Optional.of(new LotteryTicketId(ticketId));
    }

    @Override
    public Map<LotteryTicketId, LotteryTicket> findAll() {
        final Map<LotteryTicketId, LotteryTicket> map = new HashMap<>();
        final List<Document> docs = this.ticketsCollection.find(new Document()).into(new ArrayList<>());
        for (final Document doc : docs) {
            final LotteryTicket lotteryTicket = this.docToTicket(doc);
            map.put(lotteryTicket.getId(), lotteryTicket);
        }
        return map;
    }

    @Override
    public void deleteAll() {
        this.ticketsCollection.deleteMany(new Document());
    }

    private LotteryTicket docToTicket(final Document doc) {
        final PlayerDetails playerDetails = new PlayerDetails(doc.getString("email"), doc.getString("bank"), doc.getString("phone"));
        final Set<Integer> numbers = Arrays.stream(doc.getString("numbers").split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
        final LotteryNumbers lotteryNumbers = LotteryNumbers.create(numbers);
        return new LotteryTicket(new LotteryTicketId(doc.getInteger("ticketId")), playerDetails, lotteryNumbers);
    }
}
