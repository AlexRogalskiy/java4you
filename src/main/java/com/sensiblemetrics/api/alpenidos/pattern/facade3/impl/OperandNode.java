package com.sensiblemetrics.api.alpenidos.pattern.facade3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.facade3.iface.Node;
import lombok.Data;

/**
 * OperandNode, represents OperandNode in Abstract Syntax Tree.
 */
@Data
public class OperandNode implements Node {
    private int value;
}
