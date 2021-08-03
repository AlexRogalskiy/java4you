package com.sensiblemetrics.api.alpenidos.pattern.front_controller.controller;

import com.sensiblemetrics.api.alpenidos.pattern.front_controller.command.Command;
import com.sensiblemetrics.api.alpenidos.pattern.front_controller.command.UnknownCommand;
import com.sensiblemetrics.api.alpenidos.pattern.front_controller.exception.ApplicationException;

/**
 * FrontController is the handler class that takes in all the requests and renders the correct
 * response.
 */
public class FrontController {

    public void handleRequest(final String request) {
        final Command command = this.getCommand(request);
        command.process();
    }

    private Command getCommand(final String request) {
        final Class<?> commandClass = getCommandClass(request);
        try {
            return (Command) commandClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    private static Class<?> getCommandClass(final String request) {
        Class<?> result;
        try {
            result = Class.forName("com.sensiblemetrics.api.alpenidos.core.front_controller.command." + request + "Command");
        } catch (ClassNotFoundException e) {
            result = UnknownCommand.class;
        }
        return result;
    }
}
