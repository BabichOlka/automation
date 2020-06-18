package com.solvd.automation.classes.c15;

import com.solvd.automation.io.exception.UnableToWriteException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Date;

// data models (hierarchic)
// format xml (internals, usage) (html vs xml)
// serialization (marshalling/unmarshalling)
// adapters
// schema generation

public class Main {
    public static void main(String[] args) {
        Message b = new Message("dfg", 8080, "ghj", "hell", new Date());
        String pathTo = "src/main/resources/message.xml";
        writeMessage(b, pathTo);
        Message b2 = readMessage(pathTo);
        System.out.println(b2);

    }

    private static Message readMessage(String pathTo) {
        try {
            return new XMLUnmarshaller().unmarshallMessage(pathTo);
        } catch (IOException | JAXBException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException("Something went wrong while unmarshalling!");
        }

    }

    private static void writeMessage(Message b, String pathTo) {
        try {
            new XMLMarshaller().marshall(b, pathTo);
        } catch (UnableToWriteException uwe) {
            uwe.printStackTrace();
            throw new RuntimeException("Bad object type!");
        } catch (JAXBException jaxe) {
            jaxe.printStackTrace();
            throw new RuntimeException("Something went wrong while marshalling!");
        }
    }

}






//public class Main {
//    public static void main(String[] args) throws JAXBException {
//       // Book b = new Book(23423535L, "LotR", "Tolkien", new Date());
//        Message m = new Message("dfg", 8080, "ghj", "hell", new Date());
//        String pathTo = "src/main/resources/book.xml";
//        //writeBook(m, pathTo);
//       // Book b2 = readBook(pathTo);
//       // Message m2 = readBook(pathTo);
//        //System.out.println(b2);
//       // System.out.println(m2);
//
//        JAXBContext context = JAXBContext.newInstance(Message.class);
//        Marshaller mar = context.createMarshaller();
//        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        mar.marshal(m, new File(pathTo).getAbsoluteFile());
//        mar.marshal(m, System.out);
//
//
//
//
//
//
//        // xpath
//        try {
//            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
//
//            Document docExisting = domBuilder.parse(new File(pathTo).getAbsoluteFile());
//
//            XPathFactory factory = XPathFactory.newInstance();
//            XPath xpath = factory.newXPath();
//
//            NodeList list = (NodeList) xpath.evaluate(
//                    "/message/date",
//                    docExisting, XPathConstants.NODESET);
//            for (int i = 0; i < list.getLength(); i++)
//                System.out.println(list.item(i).getAttributes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static Message readBook(String pathTo) {
//        try {
//            return new XMLUnmarshaller().unmarshallBook(pathTo);
//        } catch (IOException | JAXBException ioe) {
//            ioe.printStackTrace();
//            throw new RuntimeException("Something went wrong while unmarshalling!");
//        }
//
//    }
//
//    private static void writeBook(Message b, String pathTo) {
//        try {
//            new XMLMarshaller().marshall(b, pathTo);
//        } catch (UnableToWriteException uwe) {
//            uwe.printStackTrace();
//            throw new RuntimeException("Bad object type!");
//        } catch (JAXBException jaxe) {
//            jaxe.printStackTrace();
//            throw new RuntimeException("Something went wrong while marshalling!");
//        }
//    }
//    public static void marshall(Object obj, String pathTo) throws UnableToWriteException, JAXBException {
//        if (obj.getClass().getAnnotation(XmlRootElement.class) == null) {
//            throw new UnableToWriteException("Cannot write object!");
//        }
//        JAXBContext context = JAXBContext.newInstance(Message.class);
//        Marshaller mar = context.createMarshaller();
//        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        mar.marshal(obj, new File(pathTo).getAbsoluteFile());
//    }
//
//
//}
