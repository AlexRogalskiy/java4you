package com.sensiblemetrics.api.alpenidos.core.map_reduce.model;

import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Result;

/**
 * Class ArrayResult extends abstract class {@link Result} and contains data
 * of type int[][].
 */

public class ArrayResult extends Result<int[][]> {

    public ArrayResult(final int[][] data) {
        super(data);
    }
}
