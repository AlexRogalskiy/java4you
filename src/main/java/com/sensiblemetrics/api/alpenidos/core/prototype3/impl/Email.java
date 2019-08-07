package com.sensiblemetrics.api.alpenidos.core.prototype3.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
@Getter
public class Email implements Serializable {
    private Attachment attachment = null;

    public Email() {
        this.attachment = new Attachment();
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        final ByteArrayOutputStream bao = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        final ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        final ObjectInputStream ois = new ObjectInputStream(bis);
        return (ois.readObject());
    }

    public void display() {
        log.info("Display email with attachment: " + this.getAttachment());
    }
}
