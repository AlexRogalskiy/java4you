package com.sensiblemetrics.api.alpenidos.core.abstract_factory3.button;

/**
 * EN: All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is a MacOS variant of a button.
 * <p>
 * RU: Все семейства продуктов имеют одни и те же вариации (MacOS/Windows).
 * <p>
 * Это вариант кнопки под MacOS.
 */
public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
