package com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.management;

import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Cat;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Dog;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.FerociousCat;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.FerociousDog;

public class FerociousAnimalFactory extends AbstractAnimalFactory {
    @Override
    public Cat createCat() {
        return new FerociousCat();
    }

    @Override
    public Dog createDog() {
        return new FerociousDog();
    }
}
