package ru.job4j.magnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author madrabit
 * Using SAX count amount of fields.
 */
public class Counter {
    /**
     * Sum of fields.
     */
    private static int sum = 0;
    /**
     * SAX object.
     */
    private SAXParser parser;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        Counter.sum = sum;
    }

    public Counter() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public SAXParser getParser() {
        return parser;
    }

    /**
     * Handler with counter
     */
    public static class XMLHandler extends DefaultHandler {

        /**
         * Counter
         *
         * @param uri        -
         * @param localName  -
         * @param qName      Entry attribute we count.
         * @param attributes -
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("entry")) {
                String field = attributes.getValue("field");
                sum += Integer.parseInt(field);
            }
        }
    }


}
