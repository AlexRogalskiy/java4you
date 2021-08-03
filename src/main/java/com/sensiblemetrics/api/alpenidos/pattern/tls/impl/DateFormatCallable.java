package com.sensiblemetrics.api.alpenidos.pattern.tls.impl;

import com.sensiblemetrics.api.alpenidos.pattern.tls.TlsPatternLoader;
import com.sensiblemetrics.api.alpenidos.pattern.tls.model.Result;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

/**
 * DateFormatCallable converts string dates to a date format using
 * SimpleDateFormat. The date format and the date value will be passed to the
 * Callable by the constructor. The constructor creates a instance of
 * SimpleDateFormat and stores it in a ThreadLocal class variable. For the
 * complete description of the example see {@link TlsPatternLoader}
 * <p>
 * You can comment out the code marked with //TLTL and comment in the
 * code marked //NTLNTL. Then you can see what will happen if you do not
 * use the ThreadLocal. For details see the description of {@link TlsPatternLoader}
 */
@Slf4j
public class DateFormatCallable implements Callable<Result> {
    // class variables (members)
    private ThreadLocal<DateFormat> df;    //TLTL
    // private DateFormat df;                 //NTLNTL
    private String dateValue; // for dateValue Thread Local not needed

    /**
     * The date format and the date value are passed to the constructor
     *
     * @param inDateFormat string date format string, e.g. "dd/MM/yyyy"
     * @param inDateValue  string date value, e.g. "21/06/2016"
     */
    public DateFormatCallable(final String inDateFormat, final String inDateValue) {
        final String idf = inDateFormat;                 //TLTL
        this.df = ThreadLocal.withInitial(() -> {          //TLTL
            return new SimpleDateFormat(idf);            //TLTL
        });                                               //TLTL
        // this.df = new SimpleDateFormat(inDateFormat);    //NTLNTL
        this.dateValue = inDateValue;
    }

    /**
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Result call() {
        log.info(Thread.currentThread() + " started executing...");
        final Result result = new Result();

        // Convert date value to date 5 times
        for (int i = 1; i <= 5; i++) {
            try {
                // this is the statement where it is important to have the
                // instance of SimpleDateFormat locally
                // Create the date value and store it in dateList
                result.getDateList().add(this.df.get().parse(this.dateValue));   //TLTL
//      result.getDateList().add(this.df.parse(this.dateValue));           //NTLNTL
            } catch (Exception e) {
                // write the Exception to a list and continue work
                result.getExceptionList().add(e.getClass() + ": " + e.getMessage());
            }
        }
        log.info(Thread.currentThread() + " finished processing part of the thread");
        return result;
    }
}
