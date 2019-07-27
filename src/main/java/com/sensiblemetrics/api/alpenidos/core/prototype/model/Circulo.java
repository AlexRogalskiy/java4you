package com.sensiblemetrics.api.alpenidos.core.prototype.model;

import com.sensiblemetrics.api.alpenidos.core.prototype.iface.Figura;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Circulo implements Figura {
    private String nombre;
    private int posicionX, posicionY;

    @Override
    public void setNombre(final String n) {
        this.nombre = n;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void mover(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    @Override
    public void getPosicion() {
        log.info("Circulo en x: {}", this.posicionX);
        log.info("Circulo en y: {}", this.posicionY);
    }

    @Override
    public Figura clonar() {
        final Figura figura = new Circulo();
        figura.setNombre(this.nombre);
        figura.mover(this.posicionX, this.posicionY);
        return figura;
    }
}
