package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.button;

/**
 * EN: All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is another variant of a button.
 * <p>
 * RU: Все семейства продуктов имеют одни и те же вариации (MacOS/Windows).
 * <p>
 * Это вариант кнопки под Windows.
 */
public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
