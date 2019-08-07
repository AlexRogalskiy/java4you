package com.sensiblemetrics.api.alpenidos.core.prototype3;

import com.sensiblemetrics.api.alpenidos.core.prototype3.impl.Email;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypePatternLoader {

    public static void main(final String a[]) {
        final Email email = new Email();
        Email copyEmail = null;
        try {
            copyEmail = (Email) email.deepClone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("email==copyEmail?");
        log.info("Check email equality: " + (email == copyEmail));

        log.info("email.getAttachment==copyEmail.getAttachment?");
        log.info("Check email attachment equality: " + (email.getAttachment() == copyEmail.getAttachment()));
    }
}
