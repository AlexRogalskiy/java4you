package com.sensiblemetrics.api.alpenidos.pattern.composite.model;

import com.sensiblemetrics.api.alpenidos.pattern.composite.iface.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class FinancialDepartment implements Department {
    private final Integer id;
    private final String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}
