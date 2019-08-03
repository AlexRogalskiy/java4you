package com.sensiblemetrics.api.alpenidos.core.caching.cache;

import com.sensiblemetrics.api.alpenidos.core.caching.DbManager;
import com.sensiblemetrics.api.alpenidos.core.caching.model.UserAccount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The caching strategies are implemented in this class.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheStore {

    private static LruCache cache;

    /**
     * Init cache capacity
     */
    public static void initCapacity(int capacity) {
        if (cache == null) {
            cache = new LruCache(capacity);
        } else {
            cache.setCapacity(capacity);
        }
    }

    /**
     * Get user account using read-through cache
     */
    public static UserAccount readThrough(final String userId) {
        if (cache.contains(userId)) {
            log.info("# Cache Hit!");
            return cache.get(userId);
        }
        log.info("# Cache Miss!");
        final UserAccount userAccount = DbManager.readFromDb(userId);
        cache.set(userId, userAccount);
        return userAccount;
    }

    /**
     * Get user account using write-through cache
     */
    public static void writeThrough(final UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            DbManager.updateDb(userAccount);
        } else {
            DbManager.writeToDb(userAccount);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    /**
     * Get user account using write-around cache
     */
    public static void writeAround(final UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            DbManager.updateDb(userAccount);
            // Cache data has been updated -- remove older version from cache.
            cache.invalidate(userAccount.getUserId());
        } else {
            DbManager.writeToDb(userAccount);
        }
    }

    /**
     * Get user account using read-through cache with write-back policy
     */
    public static UserAccount readThroughWithWriteBackPolicy(final String userId) {
        if (cache.contains(userId)) {
            log.info("# Cache Hit!");
            return cache.get(userId);
        }
        log.info("# Cache Miss!");
        final UserAccount userAccount = DbManager.readFromDb(userId);
        if (cache.isFull()) {
            log.info("# Cache is FULL! Writing LRU data to DB...");
            final UserAccount toBeWrittenToDb = cache.getLruData();
            DbManager.upsertDb(toBeWrittenToDb);
        }
        cache.set(userId, userAccount);
        return userAccount;
    }

    /**
     * Set user account
     */
    public static void writeBehind(final UserAccount userAccount) {
        if (cache.isFull() && !cache.contains(userAccount.getUserId())) {
            log.info("# Cache is FULL! Writing LRU data to DB...");
            final UserAccount toBeWrittenToDb = cache.getLruData();
            DbManager.upsertDb(toBeWrittenToDb);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    /**
     * Clears cache
     */
    public static void clearCache() {
        if (cache != null) {
            cache.clear();
        }
    }

    /**
     * Writes remaining content in the cache into the DB.
     */
    public static void flushCache() {
        log.info("# flushCache...");
        if (null == cache) {
            return;
        }
        cache.getCacheDataInListForm().forEach(DbManager::upsertDb);
    }

    /**
     * Print user accounts
     */
    public static String print() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n--CACHE CONTENT--\n");
        cache.getCacheDataInListForm().forEach(s -> sb.append(s + "\n"));
        sb.append("----\n");
        return sb.toString();
    }

    /**
     * Delegate to backing cache store
     */
    public static UserAccount get(final String userId) {
        return cache.get(userId);
    }

    /**
     * Delegate to backing cache store
     */
    public static void set(final String userId, final UserAccount userAccount) {
        cache.set(userId, userAccount);
    }

    /**
     * Delegate to backing cache store
     */
    public static void invalidate(final String userId) {
        cache.invalidate(userId);
    }
}
