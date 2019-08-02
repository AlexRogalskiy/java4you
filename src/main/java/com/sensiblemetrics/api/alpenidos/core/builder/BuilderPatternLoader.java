package com.sensiblemetrics.api.alpenidos.core.builder;

import com.sensiblemetrics.api.alpenidos.core.builder.model.BankAccount;

public class BuilderPatternLoader {
    public static void main(final String[] args) {
        final BankAccount newAccount = new BankAccount
            .BankAccountBuilder("Jon", "22738022275")
            .withEmail("jon@example.com")
            .withNewsletter(true)
            .build();

        System.out.println("Name: " + newAccount.getName());
        System.out.println("AccountNumber:" + newAccount.getAccountNumber());
        System.out.println("Email: " + newAccount.getEmail());
        System.out.println("Want News letter?: " + newAccount.isNewsletter());
    }
}
