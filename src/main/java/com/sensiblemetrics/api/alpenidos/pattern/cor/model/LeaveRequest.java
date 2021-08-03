package com.sensiblemetrics.api.alpenidos.pattern.cor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveRequest {
    private String leaveName;
    private int leaveDays;
}
