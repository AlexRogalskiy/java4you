package com.sensiblemetrics.api.alpenidos.pattern.pool_object;

import com.sensiblemetrics.api.alpenidos.pattern.pool_object.exception.DuplicatedInstanceException;
import com.sensiblemetrics.api.alpenidos.pattern.pool_object.exception.NotFreeInstanceException;

import java.util.Vector;

/**
 * Pool que gestiona dos objetos de tipo Reusables para poder ser compartidos.
 *
 * @author Carlos López clopezno@ubu.es
 */

public final class ReusablePool {
    private Vector<Reusable> reusables;
    private static ReusablePool instance;

    private ReusablePool(final int size) {
        this.reusables = new Vector<>(size);
        for (int i = 0; i < size; i++)
            this.reusables.add(new Reusable());
    }

    /**
     * Método singleton que crea u obtiene la única instancia del Pool que gestiona dos objetos Reusables
     *
     * @return la instancia única del Pool
     */
    public static ReusablePool getInstance() {
        if (instance == null) {
            instance = new ReusablePool(2);
        }
        return instance;
    }

    /**
     * Adquire una instancia del Objeto Reusable disponible en el Pool
     *
     * @return un objeto reusable disponible en el pool
     * @throws NotFreeInstanceException si no hay instancias de objetos reusables disponibles
     */
    public Reusable acquireReusable() throws NotFreeInstanceException {
        if (this.reusables.size() > 0) {
            Reusable r = this.reusables.lastElement();
            this.reusables.remove(r);
            return r;
        }
        throw (new NotFreeInstanceException());
    }

    /**
     * El cliente libera una instancia del objeto Reusable y se guarda en el Pool para poder ser utilizada por otro cliente.
     *
     * @param r una instancia objeto reusable
     * @throws DuplicatedInstanceException si el objeto reusable ya existe en el pool
     */

    public void releaseReusable(Reusable r) throws DuplicatedInstanceException {
        if (this.reusables.contains(r) == false) {
            this.reusables.add(r);
        }
        throw (new DuplicatedInstanceException());
    }
}
