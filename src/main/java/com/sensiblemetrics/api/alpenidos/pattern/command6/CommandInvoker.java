package com.sensiblemetrics.api.alpenidos.pattern.command6;

import com.sensiblemetrics.api.alpenidos.pattern.command6.management.OrderCommand;
import com.sensiblemetrics.api.alpenidos.pattern.command6.model.Order;
import java.util.HashMap;
import java.util.Map;

/**
 * The Command Invoker.
 * <p>
 * This gets <em>parameterised</em> by the Client.
 * <p>
 * In this example, the invoker receives new orders off an exchange and then executes them.
 *
 * @author gazbert
 */
public class CommandInvoker {

    /**
     * Map of all our commands
     */
    private final Map<String, OrderCommand> commands = new HashMap<>();

    /**
     * Sets the commands to invoke.
     * <p>
     * These are our trading order commands.
     *
     * @param id      the command Id
     * @param command the actual command to execute (later).
     */
    public void setCommand(String id, OrderCommand command) {
        this.commands.put(id, command);
    }

    /**
     * The 'business method' - we've received a new Order on the exchange.
     *
     * @param id the command id.
     */
    public void onNewOrderCommand(String id, Order order) {
        this.commands.get(id).execute(order);
    }
}
