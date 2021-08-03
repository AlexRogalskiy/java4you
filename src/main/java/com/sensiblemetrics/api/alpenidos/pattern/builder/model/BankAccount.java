package com.sensiblemetrics.api.alpenidos.pattern.builder.model;

import lombok.Getter;

@Getter
public class BankAccount {
    private String name;
    private String accountNumber;
    private String email;
    private boolean newsletter;

    //The constructor that takes a builder from which it will create object
    //the access to this is only provided to builder
    private BankAccount(final BankAccountBuilder builder) {
        this.name = builder.name;
        this.accountNumber = builder.accountNumber;
        this.email = builder.email;
        this.newsletter = builder.newsletter;
    }

    public static class BankAccountBuilder {
        private String name;
        private String accountNumber;
        private String email;
        private boolean newsletter;

        //All Mandatory parameters goes with this constructor
        public BankAccountBuilder(final String name, final String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }

        //setters for optional parameters which returns this same builder
        //to support fluent design
        public BankAccountBuilder withEmail(final String email) {
            this.email = email;
            return this;
        }

        public BankAccountBuilder withNewsletter(final boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        //the actual build method that prepares and returns a BankAccount object
        public BankAccount build() {
            return new BankAccount(this);
        }
    }
}
