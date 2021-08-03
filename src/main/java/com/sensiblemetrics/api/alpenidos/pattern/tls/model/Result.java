package com.sensiblemetrics.api.alpenidos.pattern.tls.model;

import com.sensiblemetrics.api.alpenidos.pattern.tls.TlsPatternLoader;
import com.sensiblemetrics.api.alpenidos.pattern.tls.impl.DateFormatCallable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Result object that will be returned by the Callable {@link DateFormatCallable}
 * used in {@link TlsPatternLoader}
 */
@Getter
public class Result {
    // A list to collect the date values created in one thread
    private final List<Date> dateList = new ArrayList<Date>();

    // A list to collect Exceptions thrown in one threads (should be none in
    // this example)
    private final List<String> exceptionList = new ArrayList<String>();
}
