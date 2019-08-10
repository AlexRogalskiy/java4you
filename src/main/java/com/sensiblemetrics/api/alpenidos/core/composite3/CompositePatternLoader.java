package com.sensiblemetrics.api.alpenidos.core.composite3;

import com.sensiblemetrics.api.alpenidos.core.composite3.impl.Company;
import com.sensiblemetrics.api.alpenidos.core.composite3.impl.Department;
import com.sensiblemetrics.api.alpenidos.core.composite3.impl.Organization;

public class CompositePatternLoader {

    public static void main(final String[] args) {
        final Organization shCompany = new Company("shCompany");
        final Organization shHR = new Department("shHR");
        shCompany.addOrg(shHR);
        final Organization shAdmin = new Department("shAdmin");
        shCompany.addOrg(shAdmin);
        final Organization shFinance = new Department("shFinance");
        shCompany.addOrg(shFinance);

        final Organization bjCompany = new Company("bjCompany");
        final Organization bjHR = new Department("bjHR");
        bjCompany.addOrg(bjHR);
        final Organization bjAdmin = new Department("bjAdmin");
        bjCompany.addOrg(bjAdmin);
        final Organization bjFinance = new Department("bjFinance");
        bjCompany.addOrg(bjFinance);

        final Organization company = new Company("company");
        final Organization hr = new Department("hr");
        company.addOrg(hr);
        final Organization admin = new Department("admin");
        company.addOrg(admin);
        final Organization finance = new Department("finance");
        company.addOrg(finance);

        company.addOrg(shCompany);
        company.addOrg(bjCompany);

        company.inform("Cheers");
    }
}
