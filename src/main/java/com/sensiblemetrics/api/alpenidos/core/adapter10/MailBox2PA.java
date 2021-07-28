package com.sensiblemetrics.api.alpenidos.core.adapter10;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
public interface MailBox2PA {

    void store(String email, EmailRetention retention);

    default MailBox retention(final EmailRetention retention) {
        return email -> this.store(email, retention);
    }
}
