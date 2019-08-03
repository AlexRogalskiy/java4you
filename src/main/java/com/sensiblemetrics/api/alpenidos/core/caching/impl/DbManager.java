//package com.sensiblemetrics.api.alpenidos.core.caching;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.UpdateOptions;
//import com.sensiblemetrics.api.alpenidos.core.caching.constants.CachingConstants;
//import com.sensiblemetrics.api.alpenidos.core.caching.model.UserAccount;
//import lombok.experimental.UtilityClass;
//import org.bson.Document;
//
//import java.text.ParseException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <p>DBManager handles the communication with the underlying data store i.e. Database. It contains the
// * implemented methods for querying, inserting, and updating data. MongoDB was used as the database
// * for the application.</p>
// *
// * <p>Developer/Tester is able to choose whether the application should use MongoDB as its underlying
// * data storage (connect()) or a simple Java data structure to (temporarily) store the data/objects
// * during runtime (createVirtualDB()).</p>
// */
//@UtilityClass
//public class DbManager {
//    private static MongoClient mongoClient;
//    private static MongoDatabase db;
//    private static boolean useMongoDB;
//
//    private static Map<String, UserAccount> virtualDB;
//
//    /**
//     * Create DB
//     */
//    public static void createVirtualDb() {
//        useMongoDB = false;
//        virtualDB = new HashMap<>();
//    }
//
//    /**
//     * Connect to DB
//     */
//    public static void connect() throws ParseException {
//        useMongoDB = true;
//        mongoClient = new MongoClient();
//        db = mongoClient.getDatabase("test");
//    }
//
//    /**
//     * Read user account from DB
//     */
//    public static UserAccount readFromDb(String userId) {
//        if (!useMongoDB) {
//            if (virtualDB.containsKey(userId)) {
//                return virtualDB.get(userId);
//            }
//            return null;
//        }
//        if (db == null) {
//            try {
//                connect();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        FindIterable<Document> iterable = db.getCollection(CachingConstants.USER_ACCOUNT).find(new Document(CachingConstants.USER_ID, userId));
//        if (iterable == null) {
//            return null;
//        }
//        final Document doc = iterable.first();
//        return new UserAccount(userId, doc.getString(CachingConstants.USER_NAME), doc.getString(CachingConstants.ADD_INFO));
//    }
//
//    /**
//     * Write user account to DB
//     */
//    public static void writeToDb(UserAccount userAccount) {
//        if (!useMongoDB) {
//            virtualDB.put(userAccount.getUserId(), userAccount);
//            return;
//        }
//        if (db == null) {
//            try {
//                connect();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        db.getCollection(CachingConstants.USER_ACCOUNT).insertOne(new Document(CachingConstants.USER_ID, userAccount.getUserId())
//            .append(CachingConstants.USER_NAME, userAccount.getUserName())
//            .append(CachingConstants.ADD_INFO, userAccount.getAdditionalInfo())
//        );
//    }
//
//    /**
//     * Update DB
//     */
//    public static void updateDb(UserAccount userAccount) {
//        if (!useMongoDB) {
//            virtualDB.put(userAccount.getUserId(), userAccount);
//            return;
//        }
//        if (db == null) {
//            try {
//                connect();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        db.getCollection(CachingConstants.USER_ACCOUNT).updateOne(
//            new Document(CachingConstants.USER_ID, userAccount.getUserId()),
//            new Document("$set", new Document(CachingConstants.USER_NAME, userAccount.getUserName()).append(CachingConstants.ADD_INFO, userAccount.getAdditionalInfo()))
//        );
//    }
//
//    /**
//     * Insert data into DB if it does not exist. Else, update it.
//     */
//    public static void upsertDb(final UserAccount userAccount) {
//        if (!useMongoDB) {
//            virtualDB.put(userAccount.getUserId(), userAccount);
//            return;
//        }
//        if (db == null) {
//            try {
//                connect();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        db.getCollection(CachingConstants.USER_ACCOUNT).updateOne(
//            new Document(CachingConstants.USER_ID, userAccount.getUserId()),
//            new Document("$set", new Document(CachingConstants.USER_ID, userAccount.getUserId())
//                .append(CachingConstants.USER_NAME, userAccount.getUserName())
//                .append(CachingConstants.ADD_INFO, userAccount.getAdditionalInfo())
//            ),
//            new UpdateOptions().upsert(true));
//    }
//}
