package com.sensiblemetrics.api.alpenidos.core.interpreter.iface;

import com.sensiblemetrics.api.alpenidos.core.interpreter.model.Context;

import java.util.List;

public interface Expression {

    List<String> interpret(final Context ctx);
}
