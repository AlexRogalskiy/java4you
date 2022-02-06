package com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.management;

import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Cat;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.CuteCat;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.CuteDog;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Dog;

public class CuteAnimalFactory extends AbstractAnimalFactory {

    @Override
    public Cat createCat() {
        return new CuteCat();
    }

    @Override
    public Dog createDog() {
        return new CuteDog();
    }
}
