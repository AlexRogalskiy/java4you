package com.sensiblemetrics.api.alpenidos.pattern.rule_engine.impl;

import lombok.Data;

@Data
public class Expression {

    private Integer x;
    private Integer y;
    private Operator operator;
}
