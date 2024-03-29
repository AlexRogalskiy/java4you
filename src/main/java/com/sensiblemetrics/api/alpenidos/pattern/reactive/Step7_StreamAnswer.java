package com.sensiblemetrics.api.alpenidos.pattern.reactive;

import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.function.Predicate;

interface Step7_StreamAnswer<In> extends Flow.Publisher<In> {

    default <R> Step9_MappingProcessorAnswer<In, R> map(Function<In, R> mapper) {
        Step9_MappingProcessorAnswer<In, R> processor = new Step9_MappingProcessorAnswer<>(mapper);
        this.subscribe(processor);

        return processor;
    }

    default Step10_FilteringProcessorAnswer<In> filter(Predicate<In> condition) {
        Step10_FilteringProcessorAnswer<In> processor = new Step10_FilteringProcessorAnswer<>(condition);
        this.subscribe(processor);

        return processor;
    }

    default void forEachPrint() {
        Step2_PrintingSubscriberAnswer<In> printingSubscriber = new Step2_PrintingSubscriberAnswer<>();

        this.subscribe(printingSubscriber);
    }
}
