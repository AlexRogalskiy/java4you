package com.sensiblemetrics.api.alpenidos.core.commander.model;

import lombok.Data;

import java.util.Hashtable;
import java.util.Random;

/**
 * Order class holds details of the order.
 */
@Data
public class Order {

    public enum PaymentStatus {
        NotDone,
        Trying,
        Done
    }

    public enum MessageSent {
        NoneSent,
        PaymentFail,
        PaymentTrying,
        PaymentSuccessful
    }

    private final User user;
    private final String item;
    public final String id;
    private final float price;
    private final long createdTime;
    private static final String ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final Hashtable<String, Boolean> USED_IDS = new Hashtable<String, Boolean>();
    private PaymentStatus paid;
    private MessageSent messageSent; //to avoid sending error msg on page and text more than once
    private boolean addedToEmployeeHandle; //to avoid creating more to enqueue

    public Order(User user, String item, float price) {
        this.createdTime = System.currentTimeMillis();
        this.user = user;
        this.item = item;
        this.price = price;
        String id = createUniqueId();
        if (USED_IDS.get(id) != null) {
            while (USED_IDS.get(id)) {
                id = createUniqueId();
            }
        }
        this.id = id;
        USED_IDS.put(this.id, true);
        this.paid = PaymentStatus.Trying;
        this.messageSent = MessageSent.NoneSent;
        this.addedToEmployeeHandle = false;
    }

    final String createUniqueId() {
        final StringBuilder random = new StringBuilder();
        final Random rand = new Random();
        while (random.length() < 12) {
            int index = (int) (rand.nextFloat() * ALL_CHARS.length());
            random.append(ALL_CHARS.charAt(index));
        }
        return random.toString();
    }
}
