package com.sensiblemetrics.api.alpenidos.core.prototype.iface;

public interface Figura {

    void setNombre(final String n);

    String getNombre();

    void mover(final int x, final int y);

    void getPosicion();

    Figura clonar();
}
