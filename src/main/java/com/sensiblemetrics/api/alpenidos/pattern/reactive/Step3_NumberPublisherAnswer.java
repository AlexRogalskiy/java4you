package com.sensiblemetrics.api.alpenidos.pattern.reactive;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

class Step3_NumberPublisherAnswer extends SubmissionPublisher<Integer> {

    void start() {
        IntStream.iterate(1, i -> i + 1).forEach(i -> {
            submit(i);
            sleep();
        });
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
