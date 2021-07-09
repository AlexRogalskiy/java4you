package com.sensiblemetrics.api.alpenidos.core.memento4.model;

import com.sensiblemetrics.api.alpenidos.core.memento4.model.Memento;

public class Originator {

    private Double balance;

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public Memento saveToMemento() {
        return new Memento(balance);
    }

    public void restoreToState(Memento memento) {
        balance = memento.getBalance();
    }
}
