package com.sensiblemetrics.api.alpenidos.core.singleton;

public class Sandbox {

    public static void main(final String[] args) {
        final ClassSingleton classSingleton1 = ClassSingleton.getInstance();
        //OurSingleton object1 = new OurSingleton(); // The constructor OurSingleton() is not visible
        System.out.println(classSingleton1.getInfo()); //Initial class info

        final ClassSingleton classSingleton2 = ClassSingleton.getInstance();
        classSingleton2.setInfo("New class info");

        System.out.println(classSingleton1.getInfo()); //New class info
        System.out.println(classSingleton2.getInfo()); //New class info

        //Enum singleton
        final EnumSingleton enumSingleton = EnumSingleton.INSTANCE.getInstance();
        System.out.println(enumSingleton.getInfo()); //Initial enum info
        //enumSingleton.setInfo("New enum info");
    }
}
