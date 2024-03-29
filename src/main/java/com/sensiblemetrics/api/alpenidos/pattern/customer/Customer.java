package com.sensiblemetrics.api.alpenidos.pattern.customer;

import java.util.Optional;
import java.util.function.Consumer;

public class Customer {
    private final String firstName;
    private final String surname;
    private final Integer age;
    private final String address;
    private final String phoneNumber;
    private final Sex sex;

    private Customer(final Builder builder) {
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.sex = builder.sex;
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

    @Override
    public String toString() {
        return "Customer{" +
            "firstName='" + firstName + '\'' +
            ", surname='" + surname + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", sex=" + sex +
            '}';
    }

    enum Sex {
        FEMALE,
        MALE
    }

    static class Builder {
        private final String firstName;
        private final String surname;

        public Integer age;
        public String address;
        public String phoneNumber;
        public Sex sex;

        public Builder(final String firstName, final String surname) {
            this.firstName = firstName;
            this.surname = surname;
        }

        public Builder with(final Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
