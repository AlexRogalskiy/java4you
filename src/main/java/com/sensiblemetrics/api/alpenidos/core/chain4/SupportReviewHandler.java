package com.sensiblemetrics.api.alpenidos.core.chain4;

/**
 * Handler for support team.
 */
public class SupportReviewHandler extends AbstractDocumentReviewHandler {

    @Override
    protected String[] getSelectionCriteria() {
        return new String[]{"support", "customer", "installation"};
    }

    @Override
    protected String reviewDocument(String document) {
        System.out.println("[" + document + "] This is a document for Support to review.");
        return "support";
    }
}
