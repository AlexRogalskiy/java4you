package com.sensiblemetrics.api.alpenidos.core.templatemethod;

import com.sensiblemetrics.api.alpenidos.core.templatemethod.builder.ComputerBuilder;
import com.sensiblemetrics.api.alpenidos.core.templatemethod.builder.HighEndComputerBuilder;
import com.sensiblemetrics.api.alpenidos.core.templatemethod.builder.StandardComputerBuilder;
import com.sensiblemetrics.api.alpenidos.core.templatemethod.model.Computer;

public class Application {

    public static void main(String[] args) {
        final ComputerBuilder standardComputerBuilder = new StandardComputerBuilder();
        final Computer standardComputer = standardComputerBuilder.buildComputer();
        standardComputer.getComputerParts().forEach((k, v) -> System.out.println("Part : " + k + " Value : " + v));

        final ComputerBuilder highEndComputerBuilder = new HighEndComputerBuilder();
        final Computer highEndComputer = highEndComputerBuilder.buildComputer();
        highEndComputer.getComputerParts().forEach((k, v) -> System.out.println("Part : " + k + " Value : " + v));
    }
}
