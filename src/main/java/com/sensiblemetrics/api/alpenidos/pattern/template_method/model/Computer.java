package com.sensiblemetrics.api.alpenidos.pattern.template_method.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class Computer {
    private final Map<String, String> computerParts;
}
