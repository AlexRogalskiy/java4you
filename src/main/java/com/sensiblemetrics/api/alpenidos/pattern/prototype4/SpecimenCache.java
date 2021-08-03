package com.sensiblemetrics.api.alpenidos.pattern.prototype4;

import com.sensiblemetrics.api.alpenidos.pattern.prototype4.model.Amoeba;
import com.sensiblemetrics.api.alpenidos.pattern.prototype4.model.Bacteria;
import com.sensiblemetrics.api.alpenidos.pattern.prototype4.model.Cell;
import com.sensiblemetrics.api.alpenidos.pattern.prototype4.model.SingleCell;

import java.util.EnumMap;
import java.util.Map;

public class SpecimenCache {
    private static SpecimenCache specimenCache = null;
    private final Map<Cell.CellProtoTypes, Cell> prototypeSamples = new EnumMap<Cell.CellProtoTypes, Cell>(Cell.CellProtoTypes.class);

    public static SpecimenCache getInstance() {
        if (specimenCache == null) {
            specimenCache = new SpecimenCache();
        }
        return specimenCache;
    }

    public SpecimenCache() {
        this.loadSpecimenCache();
    }

    void loadSpecimenCache() {
        this.prototypeSamples.put(Cell.CellProtoTypes.SINGLE_CELL_ORG, new SingleCell());
        this.prototypeSamples.put(Cell.CellProtoTypes.BACTERIA, new Bacteria());
        this.prototypeSamples.put(Cell.CellProtoTypes.AMOEBA, new Amoeba());
    }

    public Cell getCellProtoType(final Cell.CellProtoTypes cell) {
        return prototypeSamples.get(cell);
    }
}
