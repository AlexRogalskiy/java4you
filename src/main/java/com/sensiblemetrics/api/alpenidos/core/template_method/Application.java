package com.sensiblemetrics.api.alpenidos.core.template_method;

import com.sensiblemetrics.api.alpenidos.core.template_method.builder.ComputerBuilder;
import com.sensiblemetrics.api.alpenidos.core.template_method.builder.HighEndComputerBuilder;
import com.sensiblemetrics.api.alpenidos.core.template_method.builder.StandardComputerBuilder;
import com.sensiblemetrics.api.alpenidos.core.template_method.model.Computer;

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
