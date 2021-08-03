package com.sensiblemetrics.api.alpenidos.pattern.prototype4.model;

public abstract class Cell implements Cloneable {

    public Cell() {
        System.out.println("Constructor of Cell is called ... ");
    }

    protected String cellType;

    public enum CellProtoTypes {
        AMOEBA, BACTERIA, SINGLE_CELL_ORG
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return cellType + "with id " + hashCode();
    }

    public Object split() {
        Object cloneCell = null;
        try {
            cloneCell = this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneCell;

    }
}
