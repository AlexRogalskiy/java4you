package com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.factory;

import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Animal;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Cat;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Dog;

public interface AnimalFactory {

    Cat createCat();

    Dog createDog();

    <A extends Animal> A createCustom(Class<A> customAnimalClass);
}
