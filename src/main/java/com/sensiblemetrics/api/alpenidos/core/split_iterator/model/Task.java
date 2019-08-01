package com.sensiblemetrics.api.alpenidos.core.split_iterator.model;

import com.sensiblemetrics.api.alpenidos.core.split_iterator.model.Article;
import lombok.RequiredArgsConstructor;

import java.util.Spliterator;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class Task implements Callable<String> {
    private final Spliterator<Article> spliterator;
    private final static String SUFFIX = "- published by Baeldung";

    @Override
    public String call() {
        int current = 0;
        while (spliterator.tryAdvance(article -> article.setName(article.getName().concat(SUFFIX)))) {
            current++;
        }
        return Thread.currentThread().getName() + ":" + current;
    }
}
