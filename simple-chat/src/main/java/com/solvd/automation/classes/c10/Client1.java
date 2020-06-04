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
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Client1 {

    private static final Logger logger = LogManager.getLogger(Client.class);
    public static Set<Message> chatHistory = new LinkedHashSet<>();

    private static String pathTo = "src/main/resources/message.xml";


    public static void main(String[] args) throws InterruptedException {
        final String pathTo = "src/main/resources/message.xml";
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.parseInt(PropertyUtil.getValueByKey(C10Constant.PORT));
        final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);
        Set<Message> chatHistory = new LinkedHashSet<Message>();

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
            if (answer.equalsIgnoreCase("stop")) {
                logger.info("stop");
                break;
            } else if (answer.equalsIgnoreCase("refresh")) {
                logger.info(chatHistory);
            }
            writeMessage(message, pathTo);
            //Packable pkg = new ConnectMessage(HOST, PORT, TOKEN, answer);
            //SerializationUtil.writeObject(pkg);
            Thread.sleep(TimeConstant.TIME_TO_DELAY);
            logger.info(message.toString());
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
        //Packable pkg = new ConnectMessage(host, port, token, msg);
        //SerializationUtil.writeObject(pkg);
    }
//    private static Packable getResponse() {
//        return SerializationUtil.readResponse();
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