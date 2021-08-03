package com.sensiblemetrics.api.alpenidos.pattern.chain_of_responsibility.middleware;

/**
 * EN: Base middleware class.
 * <p>
 * RU: Базовый класс цепочки.
 */
public abstract class Middleware {

    private Middleware next;

    /**
     * EN: Builds chains of middleware objects.
     * <p>
     * RU: Помогает строить цепь из объектов-проверок.
     */
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * EN: Subclasses will implement this method with concrete checks.
     * <p>
     * RU: Подклассы реализуют в этом методе конкретные проверки.
     */
    public abstract boolean check(String email, String password);

    /**
     * EN: Runs check on the next object in chain or ends traversing if we're in last object in chain.
     * <p>
     * RU: Запускает проверку в следующем объекте или завершает проверку, если мы в последнем элементе цепи.
     */
    protected boolean checkNext(String email, String password) {
        if (this.next == null) {
            return true;
        }
        return this.next.check(email, password);
    }
}
