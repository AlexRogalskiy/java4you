package com.sensiblemetrics.api.alpenidos.core.templatemethod.builder;

public class HighEndComputerBuilder extends ComputerBuilder {

    @Override
    public void addMotherboard() {
        this.computerParts.put("Motherboard", "High-end Motherboard");
    }

    @Override
    public void setupMotherboard() {
        this.motherboardSetupStatus.add("Screwing the high-end motherboard to the case.");
        this.motherboardSetupStatus.add("Pluging in the power supply connectors.");
        this.motherboardSetupStatus.forEach(step -> System.out.println(step));
    }

    @Override
    public void addProcessor() {
        this.computerParts.put("Processor", "High-end Processor");
    }
}
