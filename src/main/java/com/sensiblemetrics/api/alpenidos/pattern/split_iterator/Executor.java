package com.sensiblemetrics.api.alpenidos.pattern.split_iterator;

import com.sensiblemetrics.api.alpenidos.pattern.split_iterator.impl.RelatedAuthorCounter;
import com.sensiblemetrics.api.alpenidos.pattern.split_iterator.model.Article;
import com.sensiblemetrics.api.alpenidos.pattern.split_iterator.model.Author;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Executor {

	public static int countAuthors(final Stream<Author> stream) {
		final RelatedAuthorCounter wordCounter = stream.reduce(new RelatedAuthorCounter(0, true), RelatedAuthorCounter::accumulate, RelatedAuthorCounter::combine);
		return wordCounter.getCounter();
	}

	public static List<Article> generateElements() {
		return Stream.generate(() -> new Article("Java")).limit(35000).collect(Collectors.toList());
	}
}
