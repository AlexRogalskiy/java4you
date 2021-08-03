package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Immutable value object containing lottery player details.
 */
@Data
@RequiredArgsConstructor
public class PlayerDetails {
    private final String emailAddress;
    private final String bankAccountNumber;
    private final String phoneNumber;

    /**
     * @return email
     */
    public String getEmail() {
        return this.emailAddress;
    }

    /**
     * @return bank account number
     */
    public String getBankAccount() {
        return this.bankAccountNumber;
    }
}
