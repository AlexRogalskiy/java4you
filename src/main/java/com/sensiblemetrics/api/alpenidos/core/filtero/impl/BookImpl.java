package com.sensiblemetrics.api.alpenidos.core.filtero.impl;

import com.sensiblemetrics.api.alpenidos.core.filtero.iface.Book;
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
