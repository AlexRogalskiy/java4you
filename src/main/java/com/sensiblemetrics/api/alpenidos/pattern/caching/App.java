package com.sensiblemetrics.api.alpenidos.pattern.caching;

import com.sensiblemetrics.api.alpenidos.pattern.caching.cache.CacheStore;
import com.sensiblemetrics.api.alpenidos.pattern.caching.cache.LruCache;
import com.sensiblemetrics.api.alpenidos.pattern.caching.enums.CachingPolicy;
import com.sensiblemetrics.api.alpenidos.pattern.caching.impl.AppManager;
import com.sensiblemetrics.api.alpenidos.pattern.caching.model.UserAccount;
import lombok.extern.slf4j.Slf4j;

/**
 * The Caching pattern describes how to avoid expensive re-acquisition of resources by not releasing
 * the resources immediately after their use. The resources retain their identity, are kept in some
 * fast-access storage, and are re-used to avoid having to acquire them again. There are four main
 * caching strategies/techniques in this pattern; each with their own pros and cons. They are;
 * <code>write-through</code> which writes data to the cache and DB in a single transaction,
 * <code>write-around</code> which writes data immediately into the DB instead of the cache,
 * <code>write-behind</code> which writes data into the cache initially whilst the data is only
 * written into the DB when the cache is full, and <code>cache-aside</code> which pushes the
 * responsibility of keeping the data synchronized in both data sources to the application itself.
 * The <code>read-through</code> strategy is also included in the mentioned four strategies --
 * returns data from the cache to the caller <b>if</b> it exists <b>else</b> queries from DB and
 * stores it into the cache for future use. These strategies determine when the data in the cache
 * should be written back to the backing store (i.e. Database) and help keep both data sources
 * synchronized/up-to-date. This pattern can improve performance and also helps to maintain
 * consistency between data held in the cache and the data in the underlying data store.
 * <p>
 * In this example, the user account ({@link UserAccount}) entity is used as the underlying
 * application data. The cache itself is implemented as an internal (Java) data structure. It adopts
 * a Least-Recently-Used (LRU) strategy for evicting data from itself when its full. The four
 * strategies are individually tested. The testing of the cache is restricted towards saving and
 * querying of user accounts from the underlying data store. The main class (
 * {@link App} is not aware of the underlying mechanics of the application (i.e. save and query) and
 * whether the data is coming from the cache or the DB (i.e. separation of concern). The AppManager
 * ({@link AppManager}) handles the transaction of data to-and-from the underlying data store
 * (depending on the preferred caching policy/strategy).
 * <p>
 * <i>{@literal CallbackPatternLoader --> AppManager --> CacheStore/LRUCache/CachingPolicy --> DBManager} </i>
 * </p>
 *
 * @see CacheStore
 * @see LruCache
 * @see CachingPolicy
 */
@Slf4j
public class App {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        AppManager.initDb(false); // VirtualDB (instead of MongoDB) was used in running the JUnit tests
        // and the CallbackPatternLoader class to avoid Maven compilation errors. Set flag to
        // true to run the tests with MongoDB (provided that MongoDB is
        // installed and socket connection is open).
        AppManager.initCacheCapacity(3);
        final App app = new App();
        app.useReadAndWriteThroughStrategy();
        app.useReadThroughAndWriteAroundStrategy();
        app.useReadThroughAndWriteBehindStrategy();
        app.useCacheAsideStategy();
    }

    /**
     * Read-through and write-through
     */
    private void useReadAndWriteThroughStrategy() {
        log.info("# CachingPolicy.THROUGH");
        AppManager.initCachingPolicy(CachingPolicy.THROUGH);

        final UserAccount userAccount1 = new UserAccount("001", "John", "He is a boy.");
        AppManager.save(userAccount1);

        log.info(AppManager.printCacheContent());
        AppManager.find("001");
        AppManager.find("001");
    }

    /**
     * Read-through and write-around
     */
    private void useReadThroughAndWriteAroundStrategy() {
        log.info("# CachingPolicy.AROUND");
        AppManager.initCachingPolicy(CachingPolicy.AROUND);

        UserAccount userAccount2 = new UserAccount("002", "Jane", "She is a girl.");
        AppManager.save(userAccount2);

        log.info(AppManager.printCacheContent());
        AppManager.find("002");

        log.info(AppManager.printCacheContent());
        userAccount2 = AppManager.find("002");
        userAccount2.setUserName("Jane G.");
        AppManager.save(userAccount2);
        log.info(AppManager.printCacheContent());
        AppManager.find("002");

        log.info(AppManager.printCacheContent());
        AppManager.find("002");
    }

    /**
     * Read-through and write-behind
     */
    private void useReadThroughAndWriteBehindStrategy() {
        log.info("# CachingPolicy.BEHIND");
        AppManager.initCachingPolicy(CachingPolicy.BEHIND);

        final UserAccount userAccount3 = new UserAccount("003", "Adam", "He likes food.");
        final UserAccount userAccount4 = new UserAccount("004", "Rita", "She hates cats.");
        final UserAccount userAccount5 = new UserAccount("005", "Isaac", "He is allergic to mustard.");

        AppManager.save(userAccount3);
        AppManager.save(userAccount4);
        AppManager.save(userAccount5);
        log.info(AppManager.printCacheContent());
        AppManager.find("003");

        log.info(AppManager.printCacheContent());

        final UserAccount userAccount6 = new UserAccount("006", "Yasha", "She is an only child.");
        AppManager.save(userAccount6);
        log.info(AppManager.printCacheContent());

        AppManager.find("004");
        log.info(AppManager.printCacheContent());
    }

    /**
     * Cache-Aside
     */
    private void useCacheAsideStategy() {
        log.info("# CachingPolicy.ASIDE");
        AppManager.initCachingPolicy(CachingPolicy.ASIDE);
        log.info(AppManager.printCacheContent());

        final UserAccount userAccount3 = new UserAccount("003", "Adam", "He likes food.");
        final UserAccount userAccount4 = new UserAccount("004", "Rita", "She hates cats.");
        final UserAccount userAccount5 = new UserAccount("005", "Isaac", "He is allergic to mustard.");
        AppManager.save(userAccount3);
        AppManager.save(userAccount4);
        AppManager.save(userAccount5);
        log.info(AppManager.printCacheContent());

        AppManager.find("003");
        log.info(AppManager.printCacheContent());
        AppManager.find("004");
        log.info(AppManager.printCacheContent());
    }
}
