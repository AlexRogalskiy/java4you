package com.sensiblemetrics.api.alpenidos.pattern.sctuctural_typing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StructuralTypingPatternLoader {

    static class A {
        public void m() {
            log.info("A::m");
        }
    }

    static class B {
        public void m() {
            log.info("B::m");
        }
    }

    static void print(Object o) throws Exception {
        o.getClass().getMethod("m").invoke(o);
    }

    public static void main(String[] args) throws Exception {
        print(new A());
        print(new B());
    }
}
