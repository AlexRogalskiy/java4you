package com.sensiblemetrics.api.alpenidos.core.facade3.impl;

import com.sensiblemetrics.api.alpenidos.core.facade3.iface.Node;
import lombok.Data;

/**
 * ExpressionNode, represents ExpressionNode in Abstract Syntax Tree.
 */
@Data
public class ExpressionNode implements Node {
    private char operator;
    private Node left;
    private Node right;
}
