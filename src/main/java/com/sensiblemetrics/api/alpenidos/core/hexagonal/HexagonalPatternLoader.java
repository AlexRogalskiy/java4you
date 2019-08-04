package com.sensiblemetrics.api.alpenidos.core.hexagonal;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.administration.ConsoleAdministration;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryAdministration;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryService;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.model.SampleData;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.module.LotteryTestingModule;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.repository.LotteryTicketRepository;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.service.ConsoleLottery;

/**
 * Hexagonal Architecture pattern decouples the application core from the
 * services it uses. This allows the services to be plugged in and the
 * application will run with or without the services.<p>
 * <p>
 * The core logic, or business logic, of an application consists of the
 * algorithms that are essential to its purpose. They implement the use
 * cases that are the heart of the application. When you change them, you
 * change the essence of the application.<p>
 * <p>
 * The services are not essential. They can be replaced without changing
 * the purpose of the application. Examples: database access and other
 * types of storage, user interface components, e-mail and other
 * communication components, hardware devices.<p>
 * <p>
 * This example demonstrates Hexagonal Architecture with a lottery system.
 * The application core is separate from the services that drive it and
 * from the services it uses.<p>
 * <p>
 * The primary ports for the application are console interfaces
 * {@link ConsoleAdministration} through which the lottery round is
 * initiated and run and {@link ConsoleLottery} that allows players to
 * submit lottery tickets for the draw.<p>
 * <p>
 * The secondary ports that application core uses are {@link WireTransfers}
 * which is a banking service, {@link LotteryEventLog} that delivers
 * eventlog as lottery events occur and {@link LotteryTicketRepository}
 * that is the storage for the lottery tickets.
 */
public class HexagonalPatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        final Injector injector = Guice.createInjector(new LotteryTestingModule());

        // start new lottery round
        final LotteryAdministration administration = injector.getInstance(LotteryAdministration.class);
        administration.resetLottery();

        // submit some lottery tickets
        final LotteryService service = injector.getInstance(LotteryService.class);
        SampleData.submitTickets(service, 20);

        // perform lottery
        administration.performLottery();
    }
}
