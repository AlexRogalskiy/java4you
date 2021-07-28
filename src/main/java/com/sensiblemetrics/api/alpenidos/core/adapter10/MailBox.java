package com.sensiblemetrics.api.alpenidos.core.adapter10;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
@FunctionalInterface
public interface MailBox {

    void store(String email);
}
