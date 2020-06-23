package ex36Strategy;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import javax.xml.parsers.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReaderSAX extends DefaultHandler implements Strategy {
    private int indent = 0;
    final static int INDENT = 4;
    private static XMLStreamWriter writer;

    double average = 0;
    double trueAverage = 0;
    int n = 0;
    int summ = 0;
    boolean isAverageTrue = true; //Среднее правильное
    boolean isCharactersAverage = false; //Это текстовые данные среднего

    public void startDocument() throws SAXException {
        printString ("Начало документа");
        try {
            writer.writeStartDocument();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void endDocument() throws SAXException {
        printString ("Конец документа");
        try {
            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException {
        indent += INDENT;
        printString ("Элемент " + qName + ":");
        try {
            writer.writeStartElement(qName);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        if (qName.equals("average")){
            isCharactersAverage = true;
        }
        for (int i = 0;i<attributes.getLength() ;i++) {
            if (attributes.getQName(i).equals("mark")){
                summ = summ + Integer.parseInt(attributes.getValue(i));
                n++;
            }
            try {
                writer.writeAttribute(attributes.getQName(i), attributes.getValue(i));
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }

    public void endElement (String uri, String localName,
                            String qName) throws SAXException {
        printString ("Конец элемента " + qName + ".");
        indent -= INDENT;
        try {
            writer.writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void warning (SAXParseException e) throws SAXException {
        System.out.println ("Предупреждение :" + e.getPublicId());
    }
    public void error (SAXParseException e) throws SAXException {
        System.out.println ("Ошибка :" + e.getPublicId());
    }
    public void fatalError (SAXParseException e) throws SAXException {
        System.out.println ("Фатальная ошибка :" + e.getPublicId());
    }

    public void characters (char[] ch, int start, int length)
            throws SAXException {
        indent += INDENT;
        String str = new String (ch, start, length);
        printString (str);
        if (isCharactersAverage){
            average = Double.parseDouble(str);
            checkAverage();
            isCharactersAverage = false;
        }
        if (isAverageTrue == false ) {
            str = Double.toString(trueAverage);
            isAverageTrue = true;
        }
        indent -= INDENT;
        try {
            writer.writeCharacters(str);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
    public void printString (String str) {
        String ind_s;
        if (indent > 0) {
            char[] ind = new char[indent];
            java.util.Arrays.fill(ind, ' ');
            ind_s = new String (ind, 0, indent);
        }
        else {
            ind_s = "";
        }
        System.out.println (ind_s + str);
    }

    public void checkAverage () {
        trueAverage = (double) summ/n;
        trueAverage = new BigDecimal(trueAverage).setScale(1, RoundingMode.UP).doubleValue();
        //System.out.println(summ);
        //System.out.println(n);
        //System.out.println(average);
        //System.out.println(trueAverage);
        if (trueAverage != average) isAverageTrue = false;
    }

    @Override
    public void parseXML(String in, String out) {
        //DefaultHandler handler = new ReaderSAX();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;

        XMLOutputFactory factoryOut = XMLOutputFactory.newInstance();
        //FileWriter out = new FileWriter("src/ex36Strategy/outputSAX.xml");
        OutputStream outStream;
        try {
            parser = factory.newSAXParser();
            outStream = new FileOutputStream(out);
            writer = factoryOut.createXMLStreamWriter (outStream);
            parser.parse (in, this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
