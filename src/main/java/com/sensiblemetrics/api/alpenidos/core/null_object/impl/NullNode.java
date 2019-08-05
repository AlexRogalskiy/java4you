package com.sensiblemetrics.api.alpenidos.core.null_object.impl;

import com.sensiblemetrics.api.alpenidos.core.null_object.iface.Node;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Null Object implementation for binary tree node.
 * <p>
 * Implemented as Singleton, since all the NullNodes are the same.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NullNode implements Node {

    private static NullNode instance = new NullNode();

    public static NullNode getInstance() {
        return instance;
    }

    @Override
    public int getTreeSize() {
        return 0;
    }

    @Override
    public Node getLeft() {
        return null;
    }

    @Override
    public Node getRight() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void walk() {
    }
}
