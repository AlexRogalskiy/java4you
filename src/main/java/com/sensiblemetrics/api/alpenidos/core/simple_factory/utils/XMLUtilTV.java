package com.sensiblemetrics.api.alpenidos.core.simple_factory.utils;

import lombok.experimental.UtilityClass;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@UtilityClass
public class XMLUtilTV {

    public static String getBrandName() {
        try {
            final DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = dFactory.newDocumentBuilder();
            final Document doc = builder.parse(new File("configTV.xml"));

            final NodeList nl = doc.getElementsByTagName("brandName");
            final Node classNode = nl.item(0).getFirstChild();
            return classNode.getNodeValue().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
