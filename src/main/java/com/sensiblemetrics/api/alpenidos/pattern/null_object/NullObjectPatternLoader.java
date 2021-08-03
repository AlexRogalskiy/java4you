package com.sensiblemetrics.api.alpenidos.pattern.null_object;

import com.sensiblemetrics.api.alpenidos.pattern.null_object.iface.Node;
import com.sensiblemetrics.api.alpenidos.pattern.null_object.impl.NodeImpl;
import com.sensiblemetrics.api.alpenidos.pattern.null_object.impl.NullNode;

/**
 * Null Object pattern replaces null values with neutral objects. Many times this simplifies
 * algorithms since no extra null checks are needed.
 * <p>
 * In this example we build a binary tree where the nodes are either normal or Null Objects. No null
 * values are used in the tree making the traversal easy.
 */
public class NullObjectPatternLoader {
    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final Node root = new NodeImpl("1",
            new NodeImpl("11",
                new NodeImpl("111", NullNode.getInstance(), NullNode.getInstance()),
                NullNode.getInstance()),
            new NodeImpl("12",
                NullNode.getInstance(), new NodeImpl("122", NullNode.getInstance(),
                NullNode.getInstance()))
        );
        root.walk();
    }
}
