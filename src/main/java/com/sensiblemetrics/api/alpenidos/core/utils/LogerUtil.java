//package com.sensiblemetrics.api.alpenidos.core.utils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Properties;
//
//public class LogerUtil {
//
//    static {
//        configuration();
//    }
//
//    private static void configuration() {
//        Properties props = new Properties();
//        try {
//            props.load(
//                new BufferedReader(
//                    new InputStreamReader(
//                        LogerUtil.class.getResourceAsStream("/log4jstructuraldp.properties")
//                    )
//                )
//            );
//        } catch (IOException e) {
//            System.out.println("log4jstructuraldp.properties file not configured properly");
//            System.exit(0);
//        }
//        PropertyConfigurator.configure(props);
//    }
//}
