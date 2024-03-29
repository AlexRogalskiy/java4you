package com.sensiblemetrics.api.alpenidos.pattern.chain_of_responsibility.middleware;

import com.sensiblemetrics.api.alpenidos.pattern.chain_of_responsibility.model.Server;

/**
 * EN: ConcreteHandler. Checks whether a user with the given credentials exists.
 * <p>
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class UserExistsMiddleware extends Middleware {

    private final Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }

        return this.checkNext(email, password);
    }
}
