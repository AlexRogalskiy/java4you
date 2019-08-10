package com.sensiblemetrics.api.alpenidos.core.interpreter3.converter;

import com.sensiblemetrics.api.alpenidos.core.interpreter3.iface.Expression;
import com.sensiblemetrics.api.alpenidos.core.interpreter3.impl.NumberExpression;
import com.sensiblemetrics.api.alpenidos.core.interpreter3.impl.UnitExpression;

import java.util.*;

import static com.sensiblemetrics.api.alpenidos.core.interpreter3.constants.InterpreterConstants.NUMBERS;
import static com.sensiblemetrics.api.alpenidos.core.interpreter3.constants.InterpreterConstants.UNITS;

public class Converter {
    /**
     * Default conveter {@link Map} instance
     */
    public static final Map<String, Map<Character, Integer>> context = new HashMap<>();
    /**
     * Default {@link Converter} instance
     */
    public static final Converter INSTANCE = new Converter();

    static {
        final Map<Character, Integer> numbers = new HashMap<>();
        numbers.put('零', 0);
        numbers.put('一', 1);
        numbers.put('二', 2);
        numbers.put('三', 3);
        numbers.put('四', 4);
        numbers.put('五', 5);
        numbers.put('六', 6);
        numbers.put('七', 7);
        numbers.put('八', 8);
        numbers.put('九', 9);
        context.put(NUMBERS, numbers);

        final Map<Character, Integer> units = new HashMap<>();
        units.put('十', 10);
        units.put('百', 100);
        units.put('千', 1000);
        units.put('万', 10000);
        units.put('亿', 100000000);
        context.put(UNITS, units);
    }

    public int convert(final String chineseNumber) {
        final Stack<Expression> stack = new Stack<>();
        for (int i = 0; i < chineseNumber.length(); ++i) {
            final Character character = chineseNumber.charAt(i);
            if ('零' == character)
                continue;

            if (context.get("numbers").containsKey(character)) {
                stack.push(new NumberExpression(character));
                continue;
            }

            if (context.get("units").containsKey(character)) {
                final List<Expression> lefts = new ArrayList<>();
                while (stack.size() > 0 && stack.peek().getPriority(context) <= context.get("units").get(character)) {
                    lefts.add(stack.pop());
                }
                stack.push(new UnitExpression(character, lefts));
                continue;
            }
        }
        return stack.stream().map(e -> e.interpret(context)).mapToInt(Integer::intValue).sum();
    }
}
