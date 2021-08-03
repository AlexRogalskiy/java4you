package com.sensiblemetrics.api.alpenidos.pattern.reactive;

class Step2_PrintingSubscriberAnswer<T> extends Step1_SubscriberBaseAnswer<T> {

    @Override
    public void onNext(T item) {
        System.out.println("onNext, item: " + item);
        subscription.request(1);
    }
}
