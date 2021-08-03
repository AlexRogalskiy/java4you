package com.sensiblemetrics.api.alpenidos.pattern.interpreter.iface;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter.model.Context;

import java.util.List;

public interface Expression {

    List<String> interpret(final Context ctx);
}
