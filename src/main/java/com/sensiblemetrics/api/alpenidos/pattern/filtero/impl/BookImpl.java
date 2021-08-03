package com.sensiblemetrics.api.alpenidos.pattern.filtero.impl;

import com.sensiblemetrics.api.alpenidos.pattern.filtero.iface.Book;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookImpl implements Book {
    private String isbn;
    private String author;
    private String title;
    private Double price;
}
