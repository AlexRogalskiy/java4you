package com.sensiblemetrics.api.alpenidos.pattern.private_class_data;

import com.sensiblemetrics.api.alpenidos.pattern.private_class_data.impl.ImmutableStew;
import com.sensiblemetrics.api.alpenidos.pattern.private_class_data.impl.Stew;
import com.sensiblemetrics.api.alpenidos.pattern.private_class_data.impl.StewData;

/**
 * The Private Class Data design pattern seeks to reduce exposure of attributes by limiting their
 * visibility. It reduces the number of class attributes by encapsulating them in single data
 * object. It allows the class designer to remove write privilege of attributes that are intended to
 * be set only during construction, even from methods of the target class.
 * <p>
 * In the example we have normal {@link Stew} class with some ingredients given in constructor. Then
 * we have methods to enumerate the ingredients and to taste the stew. The method for tasting the
 * stew alters the private members of the {@link Stew} class.
 * <p>
 * The problem is solved with the Private Class Data pattern. We introduce {@link ImmutableStew}
 * class that contains {@link StewData}. The private data members of {@link Stew} are now in
 * {@link StewData} and cannot be altered by {@link ImmutableStew} methods.
 */
public class PrivateClassDataPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // stew is mutable
        final Stew stew = new Stew(1, 2, 3, 4);
        stew.mix();
        stew.taste();
        stew.mix();

        // immutable stew protected with Private Class Data pattern
        final ImmutableStew immutableStew = new ImmutableStew(2, 4, 3, 6);
        immutableStew.mix();
    }
}
