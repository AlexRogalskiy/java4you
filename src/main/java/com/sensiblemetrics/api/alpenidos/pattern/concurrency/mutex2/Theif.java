package com.sensiblemetrics.api.alpenidos.pattern.concurrency.mutex2;

public class Theif extends Thread {

    private Bank bank;
    private final String name;

    public Theif(String name) {
        this.name = name;
    }

    public void rob(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        int stealAmount = 10;

        while (!bank.isEmpty()) {
            bank.withdrawl(stealAmount);
            System.out.println(name + " is stealing " + stealAmount + " from the bank!");
        }
    }
}
