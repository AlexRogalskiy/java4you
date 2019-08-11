package com.sensiblemetrics.api.alpenidos.core.cor2;

import com.sensiblemetrics.api.alpenidos.core.cor2.handler.DirectorPower;
import com.sensiblemetrics.api.alpenidos.core.cor2.handler.ManagerPower;
import com.sensiblemetrics.api.alpenidos.core.cor2.handler.PurchasePower;
import com.sensiblemetrics.api.alpenidos.core.cor2.handler.VicePresident;
import com.sensiblemetrics.api.alpenidos.core.cor2.impl.Command;

public class CorPatternLoader {

    public static void main(final String[] args) {
        final PurchasePower manager = new ManagerPower();
        final PurchasePower director = new DirectorPower();
        final PurchasePower vice = new VicePresident();

        manager.setSuccessor(director);
        director.setSuccessor(vice);

        manager.handleRequest(new Command(10));
        manager.handleRequest(new Command(1020));
        manager.handleRequest(new Command(200));
        manager.handleRequest(new Command(600));
    }
}
