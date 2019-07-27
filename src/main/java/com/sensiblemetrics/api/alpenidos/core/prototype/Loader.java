package com.sensiblemetrics.api.alpenidos.core.prototype;

import com.sensiblemetrics.api.alpenidos.core.prototype.iface.Figura;
import com.sensiblemetrics.api.alpenidos.core.prototype.iface.Prototype;
import com.sensiblemetrics.api.alpenidos.core.prototype.iface.PrototypeFactory;
import com.sensiblemetrics.api.alpenidos.core.prototype.model.Circulo;
import com.sensiblemetrics.api.alpenidos.core.prototype.model.ConcretePrototypeOne;
import com.sensiblemetrics.api.alpenidos.core.prototype.model.Cuadrado;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Loader {

    public static void main(final String... args) {
        final Scanner sc = new Scanner(System.in);

        int posX, posY;
        Figura figura;

        final Circulo circulo = new Circulo();
        circulo.setNombre("Mi circulo");
        circulo.mover(12, 34);

        final Cuadrado cuadrado = new Cuadrado();
        cuadrado.setNombre("Mi cuadrado");
        cuadrado.mover(200, 200);

        log.info("Estas son las figuras originales:");
        log.info("Circulo: " + circulo.getNombre());
        log.info("Cuadrado: " + cuadrado.getNombre());
        log.info("Estas son las posiciones originales:");

        circulo.getPosicion();
        cuadrado.getPosicion();

        log.info("Digite la opcion que desea clonar:");
        log.info("1 = Circulo, 2 = Cuadrado");
        if (sc.nextInt() == 1) {
            figura = circulo.clonar();
        } else {
            figura = cuadrado.clonar();
        }

        figura.setNombre(figura.getNombre() + " clonado");
        log.info("Digite la nueva posicion en X: ");
        posX = sc.nextInt();

        log.info("Digite la nueva posicion en Y: ");
        posY = sc.nextInt();
        figura.mover(posX, posY);

        log.info("Esta es figura clonada:");
        log.info(figura.getNombre());
        log.info("Esta es la posicion del clon:");

        figura.getPosicion();

        log.info("Estas son las figuras originales:");
        log.info("Circulo: " + circulo.getNombre());
        log.info("Cuadrado: " + cuadrado.getNombre());
        log.info("Estas son las posiciones originales:");

        circulo.getPosicion();
        cuadrado.getPosicion();
    }

    public static void main2(String[] args) {
        final PrototypeFactory factory = new PrototypeFactory();
        final Prototype object = new ConcretePrototypeOne();
        final ConcretePrototypeOne clonedObject = (ConcretePrototypeOne) factory.getClone(object);

        System.out.println(object);
        System.out.println(clonedObject);
        System.out.println("Object: " + System.identityHashCode(System.identityHashCode(object)));
        System.out.println("Cloned Object HashCode: " + System.identityHashCode(System.identityHashCode(clonedObject)));

    }
}
