package com.sensiblemetrics.api.alpenidos.pattern.cache.impl;

import com.sensiblemetrics.api.alpenidos.pattern.cache.enums.ClockWithOffset;
import com.sensiblemetrics.api.alpenidos.pattern.cache.iface.Clock;
import lombok.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A semi-persistent mapping from keys to values. Values are automatically loaded
 * by the cache, and are stored in the cache until evicted.
 *
 * @param <K> The type of keys maintained
 * @param <V> The type of values maintained
 */
public class ExpiringCache<K, V> {
    private final ConcurrentHashMap<K, Entry<V>> map;
    private final long expireAfterMs;
    private final Function<K, Entry<V>> entryGetter;
    private final Clock clock;

    @Data
    private static final class Entry<V> {
        private volatile long accessTime;
        private final V value;
        private final Clock clock;

        private Entry(final V value, final long accessTime, final Clock clock) {
            this.value = value;
            this.accessTime = accessTime;
            this.clock = clock;
        }

        private V getValue() {
            this.accessTime = this.clock.now();
            return this.value;
        }
    }

    private static final ScheduledExecutorService SERVICE = Executors.newSingleThreadScheduledExecutor();

    /**
     * Create a new ExpiringCache that will expire entries after a given number of milliseconds
     * computing the values as needed using the given getter.
     *
     * @param expireAfterMs Number of milliseconds after which entries will be evicted
     * @param getter        BinaryFunction that will be used to compute the values
     */
    public ExpiringCache(final long expireAfterMs, final Function<K, V> getter) {
        this(expireAfterMs, getter, TimeUnit.MINUTES.toMillis(1), ClockWithOffset.INSTANCE);
    }

    /**
     * For unit tests.
     * Create a new ExpiringCache that will expire entries after a given number of milliseconds
     * computing the values as needed using the given getter.
     *
     * @param expireAfterMs    Number of milliseconds after which entries will be evicted
     * @param getter           BinaryFunction that will be used to compute the values
     * @param expirationFreqMs Frequency at which to schedule the job that evicts entries
     *                         from the cache.
     */
    public ExpiringCache(final long expireAfterMs, final Function<K, V> getter,
                         final long expirationFreqMs, final Clock clock) {
        assert expireAfterMs > 0 : "expireAfterMs must be positive.";
        assert expirationFreqMs > 0 : "expirationFreqMs must be positive.";
        this.map = new ConcurrentHashMap<>();
        this.expireAfterMs = expireAfterMs;
        this.entryGetter = toEntry(getter);
        this.clock = clock;
        final Runnable expirationJob = () -> {
            long tooOld = clock.now() - expireAfterMs;
            map.entrySet().stream().filter(entry -> entry.getValue().accessTime < tooOld)
                .forEach(entry -> map.remove(entry.getKey(), entry.getValue()));
        };
        SERVICE.scheduleWithFixedDelay(expirationJob, 1, expirationFreqMs, TimeUnit.MILLISECONDS);
    }

    private Function<K, Entry<V>> toEntry(final Function<K, V> underlying) {
        return key -> new Entry<>(underlying.apply(key), 0L, clock);
    }

    /**
     * This method should be used instead of the
     * {@link ConcurrentHashMap#computeIfAbsent(Object, Function)} call to minimize
     * thread contention. This method does not require locking for the common case
     * where the key exists, but potentially performs additional computation when
     * absent.
     */
    private Entry<V> computeIfAbsent(K key) {
        Entry<V> v = map.get(key);
        if (v == null) {
            Entry<V> tmp = entryGetter.apply(key);
            v = map.putIfAbsent(key, tmp);
            if (v == null) {
                v = tmp;
            }
        }
        return v;
    }

    /**
     * Get the (possibly cached) value for a given key.
     */
    public V get(final K key) {
        Entry<V> entry = computeIfAbsent(key);
        return entry.getValue();
    }

    /**
     * Get the list of all values that are members of this cache. Does not
     * affect the access time used for eviction.
     */
    public List<V> values() {
        final Collection<Entry<V>> values = map.values();
        // Note below that e.value avoids updating the access time
        final List<V> res = values.stream().map(e -> e.value).collect(Collectors.toList());
        return Collections.unmodifiableList(res);
    }

    /**
     * Return the number of entries in the cache.
     */
    public int size() {
        return map.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ExpiringCache{"
            + "map=" + map
            + ", expireAfterMs=" + expireAfterMs
            + '}';
    }
}
