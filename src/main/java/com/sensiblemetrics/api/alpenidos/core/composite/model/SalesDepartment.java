package com.sensiblemetrics.api.alpenidos.core.composite.model;

import com.sensiblemetrics.api.alpenidos.core.composite.iface.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class SalesDepartment implements Department {
    private final Integer id;
    private final String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}
