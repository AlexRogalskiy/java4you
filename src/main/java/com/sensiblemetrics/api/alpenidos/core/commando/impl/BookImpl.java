package com.sensiblemetrics.api.alpenidos.core.commando.impl;

import com.sensiblemetrics.api.alpenidos.core.commando.iface.Book;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookImpl implements Book {
    private String author;
    private String title;
    private Double price;
}
