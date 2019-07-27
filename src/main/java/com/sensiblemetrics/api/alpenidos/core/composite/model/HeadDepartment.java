package com.sensiblemetrics.api.alpenidos.core.composite.model;

import com.sensiblemetrics.api.alpenidos.core.composite.iface.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class HeadDepartment implements Department {
    private final Integer id;
    private final String name;

    private final List<Department> childDepartments = new ArrayList<>();

    public void printDepartmentName() {
        this.childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(final Department department) {
        Objects.requireNonNull(department, "Department should not be null");
        this.childDepartments.add(department);
    }

    public void removeDepartment(final Department department) {
        Objects.requireNonNull(department, "Department should not be null");
        this.childDepartments.remove(department);
    }
}
