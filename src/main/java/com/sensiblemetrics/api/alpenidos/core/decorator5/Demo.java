package com.sensiblemetrics.api.alpenidos.core.decorator5;

public class Demo {

    public static void main(final String[] args) {
        final String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        final DataSourceDecorator encoded = new CompressionDecorator(
            new EncryptionDecorator(
                new FileDataSource("out/OutputDemo.txt")));
        encoded.writeData(salaryRecords);

        final DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
