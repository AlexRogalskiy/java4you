package com.sensiblemetrics.api.alpenidos.core.chain_of_responsibility.middleware;

/**
 * EN: ConcreteHandler. Checks a user's role.
 * <p>
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class RoleCheckMiddleware extends Middleware {

    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");

        return this.checkNext(email, password);
    }
}
