package com.sensiblemetrics.api.alpenidos.pattern.split_iterator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.split_iterator.model.Author;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RelatedAuthorCounter {
    private final int counter;
    private final boolean isRelated;

    public RelatedAuthorCounter accumulate(final Author author) {
        if (author.getRelatedArticleId() == 0) {
            return this.isRelated ? this : new RelatedAuthorCounter(this.counter, true);
        }
        return this.isRelated ? new RelatedAuthorCounter(this.counter + 1, false) : this;
    }

    public RelatedAuthorCounter combine(final RelatedAuthorCounter RelatedAuthorCounter) {
        return new RelatedAuthorCounter(this.counter + RelatedAuthorCounter.counter, RelatedAuthorCounter.isRelated);
    }

    public int getCounter() {
        return this.counter;
    }
}
