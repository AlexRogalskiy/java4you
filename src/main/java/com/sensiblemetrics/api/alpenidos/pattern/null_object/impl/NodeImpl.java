package com.sensiblemetrics.api.alpenidos.pattern.null_object.impl;

import com.sensiblemetrics.api.alpenidos.pattern.null_object.iface.Node;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation for binary tree's normal nodes.
 */
@Slf4j
@Data
@RequiredArgsConstructor
public class NodeImpl implements Node {
    private final String name;
    private final Node left;
    private final Node right;

    @Override
    public int getTreeSize() {
        return 1 + this.left.getTreeSize() + this.right.getTreeSize();
    }

    @Override
    public void walk() {
        log.info(this.name);
        if (this.left.getTreeSize() > 0) {
            this.left.walk();
        }
        if (this.right.getTreeSize() > 0) {
            this.right.walk();
        }
    }
}
