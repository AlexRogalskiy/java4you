package com.sensiblemetrics.api.alpenidos.pattern.sctuctural_typing;

public class StructuralTypingPatternLoader2 {
    interface I {
        void m();
    }

    static class A {
        public void m() {
            System.out.println("A::m");
        }
    }

    static class B {
        public void m() {
            System.out.println("B::m");
        }
    }

    static void print(I i) {
        i.m();
    }

    public static void main(final String[] args) {
        print(new A()::m);
        print(new B()::m);
    }
}
