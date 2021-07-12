package com.sensiblemetrics.api.alpenidos.core.abstract_factory3.checkbox;

/**
 * EN: All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is another variant of a checkbox.
 * <p>
 * RU: Все семейства продуктов имеют одинаковые вариации (MacOS/Windows).
 * <p>
 * Вариация чекбокса под Windows.
 */
public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
