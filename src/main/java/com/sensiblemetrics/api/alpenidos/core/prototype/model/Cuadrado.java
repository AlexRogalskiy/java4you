package com.sensiblemetrics.api.alpenidos.core.prototype.model;

import com.sensiblemetrics.api.alpenidos.core.prototype.iface.Figura;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Cuadrado implements Figura {
    private String nombre;
    private int posicionX, posicionY;

    @Override
    public void setNombre(final String n) {
        this.nombre = n;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void mover(final int x, final int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    @Override
    public void getPosicion() {
        log.info("Cuadrado en x: {}", this.posicionX);
        log.info("Cuadrado en y: {}", this.posicionY);
    }

    @Override
    public Figura clonar() {
        final Figura figura = new Cuadrado();
        figura.setNombre(this.nombre);
        figura.mover(this.posicionX, this.posicionY);
        return figura;
    }
}
