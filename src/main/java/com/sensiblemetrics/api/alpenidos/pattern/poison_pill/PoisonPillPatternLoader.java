package com.sensiblemetrics.api.alpenidos.pattern.poison_pill;

import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface.MessageQueue;
import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.impl.Consumer;
import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.impl.Producer;
import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.impl.SimpleMessageQueue;

/**
 * One of the possible approaches to terminate Producer-Consumer pattern is using the Poison Pill idiom. If you use Poison Pill as the termination signal then
 * Producer is responsible to notify Consumer that the exchange is over and reject any further messages. The Consumer receiving Poison Pill will stop reading
 * messages from the queue. You must also ensure that the Poison Pill will be the last message that will be read from the queue (if you have prioritized queue
 * then this can be tricky).
 * <p>
 * In simple cases the Poison Pill can be just a null-reference, but holding a unique separate shared object-marker (with name "Poison" or "Poison Pill") is
 * more clear and self describing.
 */
public class PoisonPillPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final MessageQueue queue = new SimpleMessageQueue(10000);
        final Producer producer = new Producer("PRODUCER_1", queue);
        final Consumer consumer = new Consumer("CONSUMER_1", queue);

        new Thread(consumer::consume).start();

        new Thread(() -> {
            producer.send("hand shake");
            producer.send("some very important information");
            producer.send("bye!");
            producer.stop();
        }).start();
    }
}
