package com.sensiblemetrics.api.alpenidos.core.hexagonal.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryService;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.module.LotteryModule;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.mongo.MongoConnectionPropertiesLoader;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Console interface for lottery players
 */
@Slf4j
public class ConsoleLottery {

    /**
     * Program entry point
     */
    public static void main(String[] args) {
        MongoConnectionPropertiesLoader.load();
        final Injector injector = Guice.createInjector(new LotteryModule());
        final LotteryService service = injector.getInstance(LotteryService.class);
        final WireTransfers bank = injector.getInstance(WireTransfers.class);

        try (final Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                printMainMenu();
                final String cmd = readString(scanner);
                final LotteryConsoleService lotteryConsoleService = new LotteryConsoleServiceImpl(log);
                if ("1".equals(cmd)) {
                    lotteryConsoleService.queryLotteryAccountFunds(bank, scanner);
                } else if ("2".equals(cmd)) {
                    lotteryConsoleService.addFundsToLotteryAccount(bank, scanner);
                } else if ("3".equals(cmd)) {
                    lotteryConsoleService.submitTicket(service, scanner);
                } else if ("4".equals(cmd)) {
                    lotteryConsoleService.checkTicket(service, scanner);
                } else if ("5".equals(cmd)) {
                    exit = true;
                } else {
                    log.info("Unknown command");
                }
            }
        }
    }

    private static void printMainMenu() {
        log.info("");
        log.info("### Lottery Service Console ###");
        log.info("(1) Query lottery account funds");
        log.info("(2) Add funds to lottery account");
        log.info("(3) Submit ticket");
        log.info("(4) Check ticket");
        log.info("(5) Exit");
    }

    private static String readString(Scanner scanner) {
        log.debug("> ");
        return scanner.next();
    }
}
