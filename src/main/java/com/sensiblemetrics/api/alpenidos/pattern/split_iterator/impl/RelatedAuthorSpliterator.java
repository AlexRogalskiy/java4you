package com.sensiblemetrics.api.alpenidos.pattern.split_iterator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.split_iterator.model.Author;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class RelatedAuthorSpliterator implements Spliterator<Author> {
    private final List<Author> list;
    private AtomicInteger current = new AtomicInteger();

    @Override
    public boolean tryAdvance(final Consumer<? super Author> action) {
        action.accept(this.list.get(this.current.getAndIncrement()));
        return this.current.get() < this.list.size();
    }

    @Override
    public Spliterator<Author> trySplit() {
        int currentSize = this.list.size() - this.current.get();
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2 + this.current.intValue(); splitPos < this.list.size(); splitPos++) {
            if (this.list.get(splitPos).getRelatedArticleId() == 0) {
                final Spliterator<Author> splitIterator = new RelatedAuthorSpliterator(this.list.subList(this.current.get(), splitPos));
                this.current.set(splitPos);
                return splitIterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return this.list.size() - this.current.get();
    }

    @Override
    public int characteristics() {
        return CONCURRENT;
    }

}
