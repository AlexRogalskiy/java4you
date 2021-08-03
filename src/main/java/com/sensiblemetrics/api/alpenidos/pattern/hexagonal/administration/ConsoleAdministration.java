package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.administration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryAdministration;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryService;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.model.SampleData;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.module.LotteryModule;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.mongo.MongoConnectionPropertiesLoader;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Console interface for lottery administration
 */
@Slf4j
public class ConsoleAdministration {

    /**
     * Program entry point
     */
    public static void main(String[] args) {
        MongoConnectionPropertiesLoader.load();
        final Injector injector = Guice.createInjector(new LotteryModule());
        final LotteryAdministration administration = injector.getInstance(LotteryAdministration.class);
        final LotteryService service = injector.getInstance(LotteryService.class);
        SampleData.submitTickets(service, 20);

        ConsoleAdministrationSrv consoleAdministration = new ConsoleAdministrationSrvImpl(administration, log);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                printMainMenu();
                String cmd = readString(scanner);
                if ("1".equals(cmd)) {
                    consoleAdministration.getAllSubmittedTickets();
                } else if ("2".equals(cmd)) {
                    consoleAdministration.performLottery();
                } else if ("3".equals(cmd)) {
                    consoleAdministration.resetLottery();
                } else if ("4".equals(cmd)) {
                    exit = true;
                } else {
                    log.info("Unknown command: {}", cmd);
                }
            }
        }
    }

    private static void printMainMenu() {
        log.info("");
        log.info("### Lottery Administration Console ###");
        log.info("(1) Show all submitted tickets");
        log.info("(2) Perform lottery draw");
        log.info("(3) Reset lottery ticket database");
        log.info("(4) Exit");
    }

    private static String readString(final Scanner scanner) {
        log.debug("> ");
        return scanner.next();
    }
}
