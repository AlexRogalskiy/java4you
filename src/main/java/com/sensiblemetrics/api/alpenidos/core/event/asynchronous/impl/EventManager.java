package com.sensiblemetrics.api.alpenidos.core.event.asynchronous.impl;

import com.sensiblemetrics.api.alpenidos.core.event.asynchronous.exception.EventDoesNotExistException;
import com.sensiblemetrics.api.alpenidos.core.event.asynchronous.exception.InvalidOperationException;
import com.sensiblemetrics.api.alpenidos.core.event.asynchronous.exception.LongRunningEventException;
import com.sensiblemetrics.api.alpenidos.core.event.asynchronous.exception.MaxNumOfEventsAllowedException;
import com.sensiblemetrics.api.alpenidos.core.event.asynchronous.iface.ThreadCompleteListener;
import com.sensiblemetrics.api.alpenidos.core.event.asynchronous.model.Event;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * EventManager handles and maintains a pool of event threads. {@link Event} threads are created upon user request. Thre
 * are two types of events; Asynchronous and Synchronous. There can be multiple Asynchronous events running at once but
 * only one Synchronous event running at a time. Currently supported event operations are: start, stop, and getStatus.
 * Once an event is complete, it then notifies EventManager through a listener. The EventManager then takes the event
 * out of the pool.
 */
public class EventManager implements ThreadCompleteListener {
    public static final int MAX_RUNNING_EVENTS = 1000; // Just don't wanna have too many running events. :)
    public static final int MIN_ID = 1;
    public static final int MAX_ID = MAX_RUNNING_EVENTS;
    public static final int MAX_EVENT_TIME = 1800; // in seconds / 30 minutes.
    private int currentlyRunningSyncEvent = -1;
    private Random rand;
    private Map<Integer, Event> eventPool;

    private static final String DOES_NOT_EXIST = " does not exist.";

    /**
     * EventManager constructor.
     */
    public EventManager() {
        this.rand = new Random(1);
        this.eventPool = new ConcurrentHashMap<>(MAX_RUNNING_EVENTS);
    }

    /**
     * Create a Synchronous event.
     *
     * @param eventTime Time an event should run for.
     * @return eventId
     * @throws MaxNumOfEventsAllowedException When too many events are running at a time.
     * @throws InvalidOperationException      No new synchronous events can be created when one is already running.
     * @throws LongRunningEventException      Long running events are not allowed in the app.
     */
    public int create(int eventTime) throws MaxNumOfEventsAllowedException, InvalidOperationException, LongRunningEventException {
        if (this.currentlyRunningSyncEvent != -1) {
            throw new InvalidOperationException("Event [" + currentlyRunningSyncEvent + "] is still running. Please wait until it finishes and try again.");
        }
        int eventId = createEvent(eventTime, true);
        this.currentlyRunningSyncEvent = eventId;
        return eventId;
    }

    /**
     * Create an Asynchronous event.
     *
     * @param eventTime Time an event should run for.
     * @return eventId
     * @throws MaxNumOfEventsAllowedException When too many events are running at a time.
     * @throws LongRunningEventException      Long running events are not allowed in the app.
     */
    public int createAsync(int eventTime) throws MaxNumOfEventsAllowedException, LongRunningEventException {
        return this.createEvent(eventTime, false);
    }

    private int createEvent(int eventTime, boolean isSynchronous)
        throws MaxNumOfEventsAllowedException, LongRunningEventException {
        if (eventPool.size() == MAX_RUNNING_EVENTS) {
            throw new MaxNumOfEventsAllowedException("Too many events are running at the moment. Please try again later.");
        }
        if (eventTime >= MAX_EVENT_TIME) {
            throw new LongRunningEventException(
                "Maximum event time allowed is " + MAX_EVENT_TIME + " seconds. Please try again.");
        }
        int newEventId = generateId();

        final Event newEvent = new Event(newEventId, eventTime, isSynchronous);
        newEvent.addListener(this);
        this.eventPool.put(newEventId, newEvent);
        return newEventId;
    }

    /**
     * Starts event.
     *
     * @param eventId The event that needs to be started.
     * @throws EventDoesNotExistException If event does not exist in our eventPool.
     */
    public void start(int eventId) throws EventDoesNotExistException {
        if (!this.eventPool.containsKey(eventId)) {
            throw new EventDoesNotExistException(eventId + DOES_NOT_EXIST);
        }
        this.eventPool.get(eventId).start();
    }

    /**
     * Stops event.
     *
     * @param eventId The event that needs to be stopped.
     * @throws EventDoesNotExistException If event does not exist in our eventPool.
     */
    public void cancel(int eventId) throws EventDoesNotExistException {
        if (!this.eventPool.containsKey(eventId)) {
            throw new EventDoesNotExistException(eventId + DOES_NOT_EXIST);
        }
        if (eventId == this.currentlyRunningSyncEvent) {
            this.currentlyRunningSyncEvent = -1;
        }
        this.eventPool.get(eventId).stop();
        this.eventPool.remove(eventId);
    }

    /**
     * Get status of a running event.
     *
     * @param eventId The event to inquire status of.
     * @throws EventDoesNotExistException If event does not exist in our eventPool.
     */
    public void status(int eventId) throws EventDoesNotExistException {
        if (!this.eventPool.containsKey(eventId)) {
            throw new EventDoesNotExistException(eventId + DOES_NOT_EXIST);
        }
        this.eventPool.get(eventId).status();
    }

    /**
     * Gets status of all running events.
     */
    @SuppressWarnings("rawtypes")
    public void statusOfAllEvents() {
        Iterator it = this.eventPool.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry<Integer, Event> pair = (Map.Entry<Integer, Event>) it.next();
            pair.getValue().status();
        }
    }

    /**
     * Stop all running events.
     */
    @SuppressWarnings("rawtypes")
    public void shutdown() {
        final Iterator it = this.eventPool.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry<Integer, Event> pair = (Map.Entry<Integer, Event>) it.next();
            ((Event) pair.getValue()).stop();
        }
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive. The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     */
    private int generateId() {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = this.rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        while (eventPool.containsKey(randomNum)) {
            randomNum = this.rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        }
        return randomNum;
    }

    /**
     * Callback from an {@link Event} (once it is complete). The Event is then removed from the pool.
     */
    @Override
    public void completedEventHandler(int eventId) {
        this.eventPool.get(eventId).status();
        if (this.eventPool.get(eventId).isSynchronous()) {
            this.currentlyRunningSyncEvent = -1;
        }
        this.eventPool.remove(eventId);
    }

    /**
     * Getter method for event pool.
     */
    public Map<Integer, Event> getEventPool() {
        return this.eventPool;
    }

    /**
     * Get number of currently running Synchronous events.
     */
    public int numOfCurrentlyRunningSyncEvent() {
        return this.currentlyRunningSyncEvent;
    }
}
