package com.sensiblemetrics.api.alpenidos.core.template_method.builder;

import com.sensiblemetrics.api.alpenidos.core.template_method.model.Computer;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public abstract class ComputerBuilder {
    protected final Map<String, String> computerParts = new HashMap<>();
    protected final List<String> motherboardSetupStatus = new ArrayList<>();

    public final Computer buildComputer() {
        this.addMotherboard();
        this.setupMotherboard();
        this.addProcessor();
        return getComputer();
    }

    public abstract void addMotherboard();

    public abstract void setupMotherboard();

    public abstract void addProcessor();

    private Computer getComputer() {
        return new Computer(this.computerParts);
    }
}
