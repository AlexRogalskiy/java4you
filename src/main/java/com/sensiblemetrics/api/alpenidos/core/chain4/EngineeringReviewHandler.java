package com.sensiblemetrics.api.alpenidos.core.chain4;

/**
 * Handler for Engineering team.
 */
public class EngineeringReviewHandler extends AbstractDocumentReviewHandler {

    @Override
    protected String[] getSelectionCriteria() {
        return new String[]{"engineering", "development", "developing"};
    }

    @Override
    protected String reviewDocument(String document) {
        System.out.println("[" + document + "] This is a document for Engineering to review.");
        return "engineering";
    }
}
