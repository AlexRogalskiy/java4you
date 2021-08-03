//package com.sensiblemetrics.api.alpenidos.core.functor;
//
//import com.sensiblemetrics.api.alpenidos.core.functor.iface.Conditional;
//import com.sensiblemetrics.api.alpenidos.core.functor.iface.Task;
//
//import java.util.Arrays;
//import java.util.Iterator;
//
//public class FunctorPatternLoader {
//
//    public static void main(final String[] args) {
//        // While com fluência e métodos ligados
//        While whileSample = new While();
//        Counter counter = new Counter();
//        whileSample
//            .doThis(() -> System.out.println("I'm a task!")) //Tarefa a ser realizada no loop
//            .with(() -> counter.getIndex() < 10) // condição para continuidade do loop
//            .and() // apenas para deixa bonitinho
//            .changeCounter((condit) -> counter.add()) // aplica um modificador ao contador se necessáro
//            // Ex.: interable.next();	Condit
//            //  é a condição e pode ser usada se necessário
//            .now(); // inicia efetivamente a execução do  loop.
//
//
//        // While iterator
//        While whileSample2 = new While();
//        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).iterator();
//        Task taskIterator = () -> {
//            Integer next = iterator.next();
//            System.out.println("Number: " + next);
//        };
//        whileSample2
//            .doThis(taskIterator).with()
//            .condition(() -> iterator.hasNext()) // condição para continuidade do loop
//            .now(); // inicia efetivamente a execução do  loop.
//
//
//        // While único
//        While wh2 = new While();
//        Counter counter2 = new Counter();
//        wh2.doTask(() -> counter2.getIndex() < 10, () -> System.out.println("Task 2"), (conditional) -> counter2.add());
//
//        // Separando os lambdas
//        Counter counter3 = new Counter();
//
//        Conditional conditional = () -> counter3.getIndex() < 10;
//        Task task = () -> System.out.println("Task 3");
//        CounterChanger changer = (conditionalParam) -> counter3.add();
//        wh2.doTask(conditional, task, changer);
//
//        // For único
//        For forSample = new For();
//        forSample.firstToLimit(0, 10, (i) -> System.out.println("I'm! " + i));
//        forSample.firstToLimit(10, (i) -> System.out.println("I'm! " + i));
//    }
//}
