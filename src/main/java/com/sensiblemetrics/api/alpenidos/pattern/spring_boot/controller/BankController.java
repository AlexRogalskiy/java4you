package com.sensiblemetrics.api.alpenidos.pattern.spring_boot.controller;

import com.sensiblemetrics.api.alpenidos.pattern.spring_boot.model.BankInformation;
import com.sensiblemetrics.api.alpenidos.pattern.spring_boot.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@RestController
@RequestMapping("/api/v1/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping
    private ResponseEntity banks() {
        final List<BankInformation> contacts = this.bankService.getContacts();
        return new ResponseEntity(contacts, HttpStatus.OK);
    }
}
