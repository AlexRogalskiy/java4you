package com.sensiblemetrics.api.alpenidos.pattern.composite;

import com.sensiblemetrics.api.alpenidos.pattern.composite.iface.Department;
import com.sensiblemetrics.api.alpenidos.pattern.composite.model.FinancialDepartment;
import com.sensiblemetrics.api.alpenidos.pattern.composite.model.HeadDepartment;
import com.sensiblemetrics.api.alpenidos.pattern.composite.model.SalesDepartment;

public class CompositePatternLoader {

    public static void main(final String args[]) {
        final Department salesDepartment = new SalesDepartment(1, "Sales department");
        final Department financialDepartment = new FinancialDepartment(2, "Financial department");

        final HeadDepartment headDepartment = new HeadDepartment(3, "Head department");
        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);
        headDepartment.printDepartmentName();
    }
}
