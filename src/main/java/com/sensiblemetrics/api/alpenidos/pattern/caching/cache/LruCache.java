package com.sensiblemetrics.api.alpenidos.pattern.caching.cache;

import com.sensiblemetrics.api.alpenidos.pattern.caching.model.UserAccount;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data structure/implementation of the application's cache. The data structure consists of a hash
 * table attached with a doubly linked-list. The linked-list helps in capturing and maintaining the
 * LRU data in the cache. When a data is queried (from the cache), added (to the cache), or updated,
 * the data is moved to the front of the list to depict itself as the most-recently-used data. The
 * LRU data is always at the end of the list.
 */
@Slf4j
public class LruCache {

    public class Node {
        String userId;
        UserAccount userAccount;
        Node previous;
        Node next;

        public Node(final String userId, final UserAccount userAccount) {
            this.userId = userId;
            this.userAccount = userAccount;
        }
    }

    private int capacity;
    private Map<String, Node> cache = new HashMap<>();
    private Node head;
    private Node end;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get user account
     */
    public UserAccount get(final String userId) {
        if (cache.containsKey(userId)) {
            Node node = cache.get(userId);
            remove(node);
            setHead(node);
            return node.userAccount;
        }
        return null;
    }

    /**
     * Remove node from linked list.
     */
    public void remove(final Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            end = node.previous;
        }
    }

    /**
     * Move node to the front of the list.
     */
    public void setHead(final Node node) {
        node.next = head;
        node.previous = null;
        if (head != null) {
            head.previous = node;
        }
        head = node;
        if (end == null) {
            end = head;
        }
    }

    /**
     * Set user account
     */
    public void set(final String userId, final UserAccount userAccount) {
        if (cache.containsKey(userId)) {
            Node old = cache.get(userId);
            old.userAccount = userAccount;
            remove(old);
            setHead(old);
        } else {
            Node newNode = new Node(userId, userAccount);
            if (cache.size() >= capacity) {
                log.info("# Cache is FULL! Removing {} from cache...", end.userId);
                cache.remove(end.userId); // remove LRU data from cache.
                remove(end);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            cache.put(userId, newNode);
        }
    }

    public boolean contains(String userId) {
        return cache.containsKey(userId);
    }

    /**
     * Invalidate cache for user
     */
    public void invalidate(final String userId) {
        final Node toBeRemoved = cache.remove(userId);
        if (toBeRemoved != null) {
            log.info("# {} has been updated! Removing older version from cache...", userId);
            remove(toBeRemoved);
        }
    }

    public boolean isFull() {
        return this.cache.size() >= this.capacity;
    }

    public UserAccount getLruData() {
        return this.end.userAccount;
    }

    /**
     * Clear cache
     */
    public void clear() {
        this.head = null;
        this.end = null;
        this.cache.clear();
    }

    /**
     * Returns cache data in list form.
     */
    public List<UserAccount> getCacheDataInListForm() {
        final List<UserAccount> listOfCacheData = new ArrayList<>();
        Node temp = this.head;
        while (temp != null) {
            listOfCacheData.add(temp.userAccount);
            temp = temp.next;
        }
        return listOfCacheData;
    }

    /**
     * Set cache capacity
     */
    public void setCapacity(int newCapacity) {
        if (this.capacity > newCapacity) {
            this.clear();
        } else {
            this.capacity = newCapacity;
        }
    }
}
