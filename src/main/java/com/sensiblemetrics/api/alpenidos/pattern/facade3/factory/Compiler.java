package com.sensiblemetrics.api.alpenidos.pattern.facade3.factory;

import com.sensiblemetrics.api.alpenidos.pattern.facade3.iface.Node;

import java.util.List;

/**
 * Compiler has subclasses like Tokenizer, Parser, Generator, etc. Client which
 * use a compiler do not deal with subclasses in order to compile. Compiler
 * class represents a facade. Facade hides low-level functionality from client.
 */
public class Compiler {

    public static int compile(final String input) throws Exception {
        final Parser parser = new Parser();
        final List<String> tokens = Tokenizer.tokenize(input);
        final Node expression = parser.parse(tokens);
        return Generator.generate(expression);
    }
}
