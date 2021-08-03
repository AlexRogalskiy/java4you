package com.sensiblemetrics.api.alpenidos.pattern.spring_boot.model;

import com.sensiblemetrics.api.alpenidos.pattern.spring_boot.enums.Bank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class BankInformation {
    private final Bank bank;
    private final String phoneNumber;
}
