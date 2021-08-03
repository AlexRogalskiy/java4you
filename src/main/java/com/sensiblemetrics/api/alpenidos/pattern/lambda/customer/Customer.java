package com.sensiblemetrics.api.alpenidos.pattern.lambda.customer;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sensiblemetrics.api.alpenidos.pattern.lambda.converter.ListToTripleConverter;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Created by mtumilowicz on 2018-11-24.
 */
@Value
@Builder
public class Customer {

    ImmutableList<Order> orders;
    ImmutableList<Expense> expenses;

    Optional<Order> findOrderWithMaxPrice() {
        return Lists.newArrayList(orders).stream()
            .filter(Order::hasPrice)
            .max(comparing(Order::getPrice));

    }

    Triple<Order, Order, Order> findTop3OrdersByPrice() {
        return Lists.newArrayList(orders).stream()
            .filter(Order::hasPrice)
            .sorted(comparing(Order::getPrice, reverseOrder()))
            .limit(3)
            .collect(collectingAndThen(toList(), ListToTripleConverter::convert));
    }

    ImmutableMap<Year, Set<String>> yearTagsExpensesMap() {
        return Lists.newArrayList(expenses).stream()
            .collect(collectingAndThen(groupingBy(Expense::getYear, flatMapping(Expense::getTagsStream, toSet())),
                ImmutableMap::copyOf)
            );
    }
}

@Value
@Builder
class Expense {

    Year year;
    ImmutableSet<String> tags;

    Stream<String> getTagsStream() {
        return Sets.newHashSet(tags).stream();
    }
}

@Value
@Builder
class Order {

    int id;
    BigDecimal price;

    boolean hasPrice() {
        return nonNull(price);
    }
}
