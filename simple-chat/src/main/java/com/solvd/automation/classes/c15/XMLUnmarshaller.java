package com.solvd.automation.classes.c15;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;

public class XMLUnmarshaller {
    public Message unmarshallMessage(String pathTo) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Message.class);
        return (Message) context.createUnmarshaller()
                .unmarshal(new FileReader(pathTo));
    }
}