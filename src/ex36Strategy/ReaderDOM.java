package ex36Strategy;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;


public class ReaderDOM implements Strategy {
        private int indent = 0;
        final static int INDENT = 4;
        private static final String[] TYPE_NAMES = {
                "ELEMENT_NODE", "ATTRIBUTE_NODE", "TEXT_NODE",
                "CDATA_SECTION_NODE", "ENTITY_REFERENCE_NODE",
                "ENTITY_NODE", "PROCESSING_INSTRUCTION_NODE",
                "COMMENT_NODE", "DOCUMENT_NODE", "DOCUMENT_TYPE_NODE",
                "DOCUMENT_FRAGMENT_NODE", "NOTATION_NODE"
        };
        private Document docOut;
        Element rootEl;
        Element childEl;
        Text textEl;

        double average = 0;
        double trueAverage = 0;
        int n = 0;
        int summ = 0;
        boolean isAverageTrue = true;


        public String getTypeName (short nodeType) {
            return TYPE_NAMES[nodeType - 1];
        }

    public void myPrint (Document document) {
        printNodeInfo (document);
    }

    public void printElementInfo (Element element) {
        NamedNodeMap nnm = element.getAttributes();
        for (int i = 0; i < nnm.getLength(); i++) {
            Attr attr = (Attr)nnm.item (i);
            childEl.setAttribute(attr.getName(), attr.getValue());

            if (attr.getName().equals("mark")){
                summ = summ + Integer.parseInt(attr.getValue());
                n++;
            }

            printString ("Attribute name = " + attr.getName() +
                    ", value = " + attr.getValue());
        }
    }

    public void printTextInfo (Text text) {
        printString ("Значение поля : " + text.getData());
    }

    public void printNodeInfo (Node node) {
        indent += INDENT;
        printString ("Node name = " + node.getNodeName() +
                ", node type = " + getTypeName (node.getNodeType()));
        switch (node.getNodeType()){
            case Node.DOCUMENT_NODE: {
                rootEl = docOut.createElement("student");
                rootEl.setAttribute("lastname", "Zimareva");
                docOut.appendChild(rootEl);
                break;
            }
            case Node.ELEMENT_NODE: {
                childEl = docOut.createElement(node.getNodeName());
                if (childEl.getTagName() != rootEl.getTagName()){
                    rootEl.appendChild(childEl);
                }
                if (node.getNodeName().equals("average")){
                    Node childThis = node.getFirstChild();
                    average = Double.parseDouble(((Text) childThis).getData());
                    checkAverage();
                }
                printElementInfo ((Element)node);
                //rootEl = childEl;
                break;
            }
            case Node.TEXT_NODE: {
                if (isAverageTrue) {
                    textEl = docOut.createTextNode(((Text) node).getData());
                    childEl.appendChild(textEl);
                }
                else {
                    textEl = docOut.createTextNode(Double.toString(trueAverage));
                    childEl.appendChild(textEl);
                    isAverageTrue = true;
                }
                printTextInfo ((Text)node);
                break;
            }
        }
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            printNodeInfo (nl.item (i));
        }
        indent -= INDENT;
    }

    public void printString (String str) {
        String ind_s;
        if (indent > 0) {
            char[] ind = new char[indent];
            Arrays.fill(ind, ' ');
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
        //System.out.println(average);
        //System.out.println(trueAverage);
        if (trueAverage != average) isAverageTrue = false;
        //else isAverageTrue = true;
    }

    @Override
    public void parseXML(String in, String out) {
        try {
            //чтение
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document docIn = builder.parse(in);

            this.docOut = builder.newDocument();
            this.myPrint(docIn);

            //запись
            DOMSource dom_source = new DOMSource(this.docOut);
            StreamResult out_stream = new StreamResult(out);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            DocumentType docType = docIn.getDoctype();
            String systemID = docType.getSystemId();
            transformer.setOutputProperty (OutputKeys.DOCTYPE_SYSTEM, systemID);
            transformer.transform(dom_source, out_stream);
        } catch (TransformerConfigurationException e){
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}