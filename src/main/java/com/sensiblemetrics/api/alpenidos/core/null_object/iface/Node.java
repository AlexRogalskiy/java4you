package com.sensiblemetrics.api.alpenidos.core.null_object.iface;

/**
 * Interface for binary tree node.
 */
public interface Node {

    String getName();

    int getTreeSize();

    Node getLeft();

    Node getRight();

    void walk();
}
