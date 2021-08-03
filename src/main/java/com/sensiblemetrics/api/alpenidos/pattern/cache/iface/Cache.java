package com.sensiblemetrics.api.alpenidos.pattern.cache.iface;

/**
 * Abstraction for a Caching mechanism. All Axon component rely on this abstraction, so that different
 * providers can be plugged in. In future versions, this abstraction may be replaced with the {@code javax.cache}
 * api, as soon as that api is final.
 *
 * @author Allard Buijze
 * @since 2.1.2
 */
public interface Cache {

    /**
     * Returns an item from the cache, or {@code null} if no item was stored under that key
     *
     * @param key The key under which the item was cached
     * @param <K> The type of key used
     * @param <V> The type of value stored
     * @return the item stored under the given key
     */
    <K, V> V get(final K key);

    /**
     * Stores the given {@code value} in the cache, under given {@code key}. If an item already exists,
     * it is updated with the new value.
     *
     * @param key   The key under which to store the item
     * @param value The item to cache
     * @param <K>   The type of key used
     * @param <V>   The type of value stored
     */
    <K, V> void put(final K key, final V value);

    /**
     * Stores the given {@code value} in the cache, under given {@code key}, if no element is yet available
     * under that key. This operation is performed atomically.
     *
     * @param key   The key under which to store the item
     * @param value The item to cache
     * @param <K>   The type of key used
     * @param <V>   The type of value stored
     * @return {@code true} if no value was previously assigned to the key, {@code false} otherwise.
     */
    <K, V> boolean putIfAbsent(final K key, final V value);

    /**
     * Removes the entry stored under given {@code key}. If no such entry exists, nothing happens.
     *
     * @param key The key under which the item was stored
     * @param <K> The type of key used
     * @return {@code true} if a value was previously assigned to the key and has been removed, {@code false}
     * otherwise.
     */
    <K> boolean remove(final K key);

    /**
     * Indicates whether there is an item stored under given {@code key}.
     *
     * @param key The key to check
     * @param <K> The type of key
     * @return {@code true} if an item is available under that key, {@code false} otherwise.
     */
    <K> boolean containsKey(final K key);

    /**
     * Registers the given {@code cacheEntryListener} to listen for Cache2 changes.
     *
     * @param cacheEntryListener The listener to register
     * @return a handle to unregister the listener
     */
    <K, V> void registerCacheEntryListener(final EntryListener<K, V> cacheEntryListener);

    /**
     * Interface describing callback methods, which are invoked when changes are made in the underlying cache.
     */
    interface EntryListener<K, V> {

        /**
         * Invoked when an entry has expired.
         *
         * @param key The key of the entry that expired
         */
        void onEntryExpired(final K key);

        /**
         * Invoked when an item was removed from the cache, either following an expiry, or by explicitly calling
         *
         * @param key The key of the entry that was removed
         */
        void onEntryRemoved(final K key);

        /**
         * Invoked when an item has been updated.
         *
         * @param key   The key of the entry that was updated
         * @param value The new value of the entry
         */
        void onEntryUpdated(final K key, final V value);

        /**
         * Invoked when a new item has been added to the cache
         *
         * @param key   The key of the entry that was added
         * @param value The value of the entry
         */
        void onEntryCreated(final K key, final V value);

        /**
         * Invoked when an item was retrieved from the Cache2
         *
         * @param key   The key of the entry that was read
         * @param value The value of the entry read
         */
        void onEntryRead(final K key, final V value);

        /**
         * Clone operation used by some Cache2 implementations. An implementation must implement {@link
         * Cloneable} to indicate it supports cloning.
         *
         * @return a copy of this instance
         * @throws CloneNotSupportedException if cloning is not supported
         * @see Cloneable
         */
        Object clone() throws CloneNotSupportedException;
    }

    /**
     * Adapter implementation for the EntryListener, allowing for overriding only specific callback methods.
     */
    class EntryListenerAdapter<K, V> implements EntryListener<K, V> {

        @Override
        public void onEntryExpired(final K key) {
        }

        @Override
        public void onEntryRemoved(final K key) {
        }

        @Override
        public void onEntryUpdated(final K key, final V value) {
        }

        @Override
        public void onEntryCreated(final K key, final V value) {
        }

        @Override
        public void onEntryRead(final K key, final V value) {
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
