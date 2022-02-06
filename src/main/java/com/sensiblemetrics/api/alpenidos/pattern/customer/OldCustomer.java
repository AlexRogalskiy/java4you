package com.sensiblemetrics.api.alpenidos.pattern.customer;

import java.util.Optional;

public class OldCustomer {
    private final String firstName;
    private final String surname;
    private final Integer age;
    private final String address;
    private final String phoneNumber;
    private final Sex sex;

    private OldCustomer(final Builder builder) {
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.sex = builder.sex;
    }

    public static Builder builderOf(final String firstName, final String surname) {
        return new Builder(firstName, surname);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phoneNumber);
    }

    public Optional<Sex> getSex() {
        return Optional.ofNullable(sex);
    }

    enum Sex {
        FEMALE,
        MALE
    }

    static class Builder {
        private final String firstName;
        private final String surname;
        private Integer age;
        private String address;
        private String phoneNumber;
        private Sex sex;

        private Builder(final String firstName, final String surname) {
            this.firstName = firstName;
            this.surname = surname;
        }

        public Builder withAge(final Integer age) {
            this.age = age;
            return this;
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder withPhoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withSex(final Sex sex) {
            this.sex = sex;
            return this;
        }

        public OldCustomer build() {
            return new OldCustomer(this);
        }
    }
}
