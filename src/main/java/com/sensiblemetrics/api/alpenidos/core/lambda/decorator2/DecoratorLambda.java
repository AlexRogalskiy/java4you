package com.sensiblemetrics.api.alpenidos.core.lambda.decorator2;

public class DecoratorLambda {

    static double calculate(int annualGrossSalary) {
        return new DefaultSalaryCalculator()
            .andThen(Taxes::generalTax)
            .andThen(Taxes::regionalTax)
            .andThen(Taxes::healthInsurance)
            .applyAsDouble(annualGrossSalary);
    }
}
