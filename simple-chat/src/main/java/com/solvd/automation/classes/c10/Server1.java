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
import java.util.*;
import java.util.logging.Logger;

public class Server1 {
    private static final Logger LOGGER = Logger.getLogger(Server1.class.getSimpleName());
    public static List<Message> chatHistory = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> AVAILABLE_CLIENTS = Arrays.asList("user");
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static HashSet<MessegeFilter> filters = new HashSet<>();
    private static String pathTo = "src/main/resources/message.xml";

    static {
        filters.add(new EmodgiFilter());
        filters.add(new PoinFilter());
        filters.add(new CountryFilter());
        filters.add(new CapitalFilter());
        filters.add(new OffensesFilter());
        filters.add(new NameFilter());
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
        if (msg != null) {
            Connection conn = new Connection(pathTo);
            conn.start();
            if (msg.getHost().equals(HOST) && msg.getPort() == PORT && AVAILABLE_CLIENTS.contains(msg.getToken())) {
                String m = "";
                for (MessegeFilter filter : filters) {
                    m = filter.apply(msg.getMsg());
                }
                msg.setMsg(m);
                chatHistory.add(msg);
                LOGGER.info(msg.toString());
                writeMessage(msg, pathTo);

            }
        }
    }

    private static String filterMsg(String message) {
        for (MessegeFilter filter : filters) {
            message = filter.apply(message);
        }
        return message;
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

    static class Connection extends Thread {

        private String path;

        public Connection(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            Message msg = readMessage(path);
            LOGGER.info(msg.getMsg());
            chatHistory.add(msg);
        }

    }
}


