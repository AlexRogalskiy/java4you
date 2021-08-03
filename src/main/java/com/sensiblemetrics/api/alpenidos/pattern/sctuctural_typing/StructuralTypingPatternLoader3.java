package com.sensiblemetrics.api.alpenidos.pattern.sctuctural_typing;

public class StructuralTypingPatternLoader3 {
    interface I {
        void m();
    }

    static class A implements I {
        public void m() {
            System.out.println("A::m");
        }
    }

    static class B implements I {
        public void m() {
            System.out.println("B::m");
        }
    }

    static void print(final I i) {
        i.m();
    }

    public static void main(final String[] args) {
        print(new A());
        print(new B());
    }
}
