package com.solvd.automation.classes.c10;


import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.solvd.automation.classes.c10.filter.impl.*;
import com.solvd.automation.classes.c15.Message;
import com.solvd.automation.classes.c15.XMLMarshaller;
import com.solvd.automation.classes.c15.XMLUnmarshaller;
import com.solvd.automation.constant.TimeConstant;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.exception.UnableToWriteException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Server1 {
    private static final Logger LOGGER = Logger.getLogger(Server1.class.getSimpleName());
    public static Set<Message> chatHistory = new HashSet<>();
    private static final List<String> AVAILABLE_CLIENTS = Arrays.asList("user");
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static Set<MessegeFilter> filters = new HashSet<>();
    private  static String pathTo = "src/main/resources/message.xml";

    static {
        filters.add(new NameFilter());
        filters.add(new CountryFilter());
        filters.add(new CapitalFilter());
        filters.add(new EmodgiFilter());
        filters.add(new OffensesFilter());
        filters.add(new PoinFilter());
    }
    public static void main(String[] args) {
        LOGGER.info(String.format("Listening on %s:%d", HOST, PORT));
        while (true) {
            try {
                listen();
                Thread.sleep(TimeConstant.TIME_TO_DELAY);
            } catch (InterruptedException | UnableToReadException e) {
                e.printStackTrace();
            }
        }
    }
    // TODO: filter msgs
    public static void listen() throws UnableToReadException {
        Message msg = readMessage(pathTo);
        //Packable obj = SerializationUtil.readObject();
        if (msg != null) {
            //ConnectMessage msg = ((ConnectMessage) obj);

            if (msg.getHost().equals(HOST) && msg.getPort() == PORT && AVAILABLE_CLIENTS.contains(msg.getToken())) {
                String m;

                for (MessegeFilter filter : filters) {
                    m = filter.apply(msg.getMsg());
                }
                //String ms = m;
                chatHistory.add(msg);
                //System.out.println(chatHistory);
                LOGGER.info(msg.toString());
                writeMessage(msg, pathTo);
                //Packable resp = new ResponseMessage(HOST, PORT, "", m, 200);
               // sendResponse(resp);
            }
        }
    }
    private static String filterMsg(String message) {
        for (MessegeFilter filter : filters) {
            message = filter.apply(message);
        }
        return message;
    }

//    private static void sendResponse(Packable pkg) {
//        SerializationUtil.writeResponse(pkg);
//    }

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


