package com.sensiblemetrics.api.alpenidos.core.chain4;

/**
 * Provides operations that each concrete Handler impl must provide.
 */
public interface DocumentReviewHandler {

    /**
     * Sets the next handler. The abstract impl usually calls this instead of each concrete impl.
     *
     * @param handler the doc review handler.
     */
    void setNextHandler(DocumentReviewHandler handler);

    /**
     * Each handler provides its own impl to do something with the message.
     *
     * @param document the doc.
     */
    void processHandler(String document);
}
