package com.sensiblemetrics.api.alpenidos.core.composite3.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public abstract class Organization {
    private final List<Organization> childOrgs = new ArrayList<>();

    private final String name;

    public void addOrg(final Organization org) {
        this.childOrgs.add(org);
    }

    public void removeOrg(final Organization org) {
        this.childOrgs.remove(org);
    }

    public abstract void inform(final String info);
}
