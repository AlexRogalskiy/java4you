package com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous;

import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.exception.EventDoesNotExistException;
import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.exception.InvalidOperationException;
import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.exception.LongRunningEventException;
import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.exception.MaxNumOfEventsAllowedException;
import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.impl.EventManager;
import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.model.Event;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * This application demonstrates the <b>Event-based Asynchronous</b> pattern. Essentially, users (of the pattern) may
 * choose to run events in an Asynchronous or Synchronous mode. There can be multiple Asynchronous events running at
 * once but only one Synchronous event can run at a time. Asynchronous events are synonymous to multi-threads. The key
 * point here is that the threads run in the background and the user is free to carry on with other processes. Once an
 * event is complete, the appropriate listener/callback method will be called. The listener then proceeds to carry out
 * further processing depending on the needs of the user.
 * <p>
 * The {@link EventManager} manages the events/threads that the user creates. Currently, the supported event operations
 * are: <code>start</code>, <code>stop</code>, <code>getStatus</code>. For Synchronous events, the user is unable to
 * start another (Synchronous) event if one is already running at the time. The running event would have to either be
 * stopped or completed before a new event can be started.
 * <p>
 * The Event-based Asynchronous Pattern makes available the advantages of multithreaded applications while hiding many
 * of the complex issues inherent in multithreaded design. Using a class that supports this pattern can allow you to:-
 * (1) Perform time-consuming tasks, such as downloads and database operations, "in the background," without
 * interrupting your application. (2) Execute multiple operations simultaneously, receiving notifications when each
 * completes. (3) Wait for resources to become available without stopping ("hanging") your application. (4) Communicate
 * with pending asynchronous operations using the familiar events-and-delegates model.
 *
 * @see EventManager
 * @see Event
 */
@Slf4j
public class EventAsyncPatternLoader {
    public static final String PROP_FILE_NAME = "config.properties";
    boolean interactiveMode = false;

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final EventAsyncPatternLoader app = new EventAsyncPatternLoader();
        app.setUp();
        app.run();
    }

    /**
     * EventAsyncPatternLoader can run in interactive mode or not. Interactive mode == Allow user interaction with command line.
     * Non-interactive is a quick sequential run through the available {@link EventManager} operations.
     */
    public void setUp() {
        final Properties prop = new Properties();
        final InputStream inputStream = EventAsyncPatternLoader.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                log.error("{} was not found. Defaulting to non-interactive mode.", PROP_FILE_NAME, e);
            }
            final String property = prop.getProperty("INTERACTIVE_MODE");
            if (property.equalsIgnoreCase("YES")) {
                this.interactiveMode = true;
            }
        }
    }

    /**
     * Run program in either interactive mode or not.
     */
    public void run() {
        if (this.interactiveMode) {
            this.runInteractiveMode();
        } else {
            this.quickRun();
        }
    }

    /**
     * Run program in non-interactive mode.
     */
    public void quickRun() {
        final EventManager eventManager = new EventManager();
        try {
            // Create an Asynchronous event.
            int aEventId = eventManager.createAsync(60);
            log.info("Async Event [{}] has been created.", aEventId);
            eventManager.start(aEventId);
            log.info("Async Event [{}] has been started.", aEventId);

            // Create a Synchronous event.
            int sEventId = eventManager.create(60);
            log.info("Sync Event [{}] has been created.", sEventId);
            eventManager.start(sEventId);
            log.info("Sync Event [{}] has been started.", sEventId);

            eventManager.status(aEventId);
            eventManager.status(sEventId);

            eventManager.cancel(aEventId);
            log.info("Async Event [{}] has been stopped.", aEventId);
            eventManager.cancel(sEventId);
            log.info("Sync Event [{}] has been stopped.", sEventId);
        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException | InvalidOperationException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Run program in interactive mode.
     */
    public void runInteractiveMode() {
        final EventManager eventManager = new EventManager();
        Scanner s = new Scanner(System.in);
        int option = -1;
        while (option != 4) {
            log.info("Hello. Would you like to boil some eggs?");
            log.info("(1) BOIL AN EGG \n(2) STOP BOILING THIS EGG \n(3) HOW ARE MY EGGS? \n(4) EXIT");
            log.info("Choose [1,2,3,4]: ");
            option = s.nextInt();
            if (option == 1) {
                processOption1(eventManager, s);
            } else if (option == 2) {
                processOption2(eventManager, s);
            } else if (option == 3) {
                processOption3(eventManager, s);
            } else if (option == 4) {
                eventManager.shutdown();
            }
        }
        s.close();
    }

    private void processOption3(final EventManager eventManager, final Scanner s) {
        s.nextLine();
        log.info("Just one egg (O) OR all of them (A) ?: ");
        String eggChoice = s.nextLine();

        if (eggChoice.equalsIgnoreCase("O")) {
            log.info("Which egg?: ");
            int eventId = s.nextInt();
            try {
                eventManager.status(eventId);
            } catch (EventDoesNotExistException e) {
                log.error(e.getMessage());
            }
        } else if (eggChoice.equalsIgnoreCase("A")) {
            eventManager.statusOfAllEvents();
        }
    }

    private void processOption2(final EventManager eventManager, final Scanner s) {
        log.info("Which egg?: ");
        int eventId = s.nextInt();
        try {
            eventManager.cancel(eventId);
            log.info("Egg [{}] is removed from boiler.", eventId);
        } catch (EventDoesNotExistException e) {
            log.error(e.getMessage());
        }
    }

    private void processOption1(final EventManager eventManager, final Scanner s) {
        s.nextLine();
        log.info("Boil multiple eggs at once (A) or boil them one-by-one (S)?: ");
        String eventType = s.nextLine();
        log.info("How long should this egg be boiled for (in seconds)?: ");
        int eventTime = s.nextInt();
        if (eventType.equalsIgnoreCase("A")) {
            try {
                int eventId = eventManager.createAsync(eventTime);
                eventManager.start(eventId);
                log.info("Egg [{}] is being boiled.", eventId);
            } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException e) {
                log.error(e.getMessage());
            }
        } else if (eventType.equalsIgnoreCase("S")) {
            try {
                int eventId = eventManager.create(eventTime);
                eventManager.start(eventId);
                log.info("Egg [{}] is being boiled.", eventId);
            } catch (MaxNumOfEventsAllowedException | InvalidOperationException | LongRunningEventException
                | EventDoesNotExistException e) {
                log.error(e.getMessage());
            }
        } else {
            log.info("Unknown event type.");
        }
    }
}
