/**
 * XC
 * XML Command Line Tool
 * GitHub: https://www.github.com/0x4248/XC
 * Licence: GNU General Public License v3.0
 * Author: 0x4248
 *
 * XC is a command line tool for reading and writing XML files. It allows
 * you to get the value of an element, get the attributes of an element, and
 * set the value of an element. This can be useful for bash scripts and other
 * command line tools.
 */


package com.github._0x4248;

/* Basic Java imports */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

/* XML imports */
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/* XML imports for parsing and transforming */
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;


public class Main {
    public static String file = "";
    public static String location = "";
    public static String mode = "";
    public static String input = "";
    public static List<String> flags = new ArrayList<>();

    /**
     * Main method
     * @param args
     * @throws ParserConfigurationException
     */
    public static void main(String[] args) throws ParserConfigurationException {
        Logger.log("Starting XC");

        Args.parseArgs(args);

        try {
            File xmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Logger.log("XML file loaded");

            Element root = doc.getDocumentElement();
            Logger.debug("Root element: " + root.getNodeName());

            String[] locationArray = location.split("/");
            Logger.debug("Location array: " + Arrays.toString(locationArray));

            Element element = root;

            for (String loc : locationArray) {
                Logger.debug("Getting element: " + loc);
                NodeList nodeList = element.getElementsByTagName(loc);
                Logger.debug("Node list: " + nodeList.getLength());
                if (nodeList.getLength() == 0) {
                    Logger.error("Element not found: " + loc);
                    System.exit(1);
                }
                element = (Element) nodeList.item(0);
            }

            Logger.debug("Element: " + element.getNodeName());

            if (mode.equals("get")) {
                Logger.log("Getting element: " + element.getNodeName());
                System.out.println(element.getTextContent());
            } else if (mode.equals("get-attr")) {
                Logger.log("Getting attributes of element: " + element.getNodeName());
                NamedNodeMap attributes = element.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.println(attribute.getNodeName() + ": " + attribute.getNodeValue());
                }
            } else if (mode.equals("set")) {
                Logger.log("Setting element: " + element.getNodeName());
                Logger.log("Value: " + input);
                element.setTextContent(input);
            } else {
                Logger.error("Invalid mode: " + mode);
                System.exit(1);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);

            Logger.log("Changes saved to file");
        } catch (SAXException | IOException | TransformerException | ParserConfigurationException e) {
            Logger.error("Error loading XML file: " + e.getMessage());
            System.exit(1);
        }
    }
}
