package com.sensiblemetrics.api.alpenidos.pattern.reactive;

import java.util.function.Function;

class Step9_MappingProcessorAnswer<In, Out> extends Step5_MappingProcessorAnswer<In, Out>
    implements Step7_StreamAnswer<Out> {

    Step9_MappingProcessorAnswer(Function<In, Out> mapper) {
        super(mapper);
    }
}
