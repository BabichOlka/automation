package com.solvd.automation.classes.c10;

import com.solvd.automation.classes.c15.Message;
import com.solvd.automation.classes.c15.XMLMarshaller;
import com.solvd.automation.classes.c15.XMLUnmarshaller;
import com.solvd.automation.constant.C10Constant;
import com.solvd.automation.constant.TimeConstant;
import com.solvd.automation.io.exception.UnableToWriteException;
import com.solvd.automation.util.PropertyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.*;

public class Client1 {

    private static final Logger logger = LogManager.getLogger(Client.class);
    public static List<Message> chatHistory = Collections.synchronizedList(new ArrayList<>());

    private static String pathTo = "src/main/resources/message.xml";

    public static void main(String[] args) throws InterruptedException {
        final String pathTo = "src/main/resources/message.xml";
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.parseInt(PropertyUtil.getValueByKey(C10Constant.PORT));
        final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);
        List<Message> chatHistory = new ArrayList<>();

        connect(HOST, PORT, TOKEN, new Date());

        Scanner in = new Scanner(System.in);

        while (true) {
            logger.info("Enter your message:");
            Message message = new Message();
            String answer = in.nextLine();
            message.setMsg(answer);
            message.setDate(new Date());
            message.setHost(HOST);
            message.setPort(PORT);
            message.setToken(TOKEN);
            chatHistory.add(message);
            writeMessage(message, pathTo);
            if (answer.equalsIgnoreCase("stop")) {
                logger.info("stop");
                break;
            } else if (answer.equalsIgnoreCase("refresh")) {
                sortHistory(chatHistory);
                logger.info(chatHistory);
            }
            readMessage(pathTo);

            Thread.sleep(TimeConstant.TIME_TO_DELAY);
            logger.info(readMessage(pathTo));
        }
    }

    private static void connect(final String host, final int port, final String token, Date date) {
        Message message = new Message();
        String msg = "Connection";
        message.setMsg(msg);
        message.setDate(new Date());
        message.setHost(host);
        message.setPort(port);
        message.setToken(token);
        writeMessage(message, pathTo);

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

    public static void sortHistory(List<Message> chatHistory) {
        sort(chatHistory, new Comparator<Message>() {
            public int compare(Message o1, Message o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

    }

}