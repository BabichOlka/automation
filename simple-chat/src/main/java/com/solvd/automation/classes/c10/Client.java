package com.solvd.automation.classes.c10;

import com.solvd.automation.classes.c10.bo.ConnectMessage;
import com.solvd.automation.classes.c10.bo.ResponseMessage;
import com.solvd.automation.constant.C10Constant;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.interfaces.Packable;
import com.solvd.automation.util.PropertyUtil;
import com.solvd.automation.util.SerializationUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1. object streams
 * 2. task
 * 3. swap strings
 * 33. loggers (stdin, stdout, stderr)
 * 4. refactoring
 * 5. fixes
 */
public class Client {

    private static final Logger logger = LogManager.getLogger(Client.class);

    public static void main(String[] args) throws IOException, UnableToReadException {
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.parseInt(PropertyUtil.getValueByKey(C10Constant.PORT));
        final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);

        String path = "src/main/resources/client1";

        try {
            Path p = Paths.get(path);
            try {
                Files.createFile(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
            connect( HOST, PORT, TOKEN);
            logger.info(((ResponseMessage) getResponse()).getResp());
            //System.out.println(((ResponseMessage) getResponse()).getResp());

            Scanner in = new Scanner(System.in);

            while (true) {
                logger.info("Enter your message:");
                String answer = in.nextLine();
                if (StringUtils.trim(answer).equalsIgnoreCase("GoodBye")) {
                    break;
                }
                Packable pkg = new ConnectMessage(HOST, PORT, TOKEN, answer);
                SerializationUtil.writeObject(pkg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Files.delete(Paths.get(path));
        }

    }

    private static void connect( final String host, final int port, final String token) {
        String msg = "Conn";
        Packable pkg = new ConnectMessage(host, port, token, msg);
        SerializationUtil.writeObject(pkg);
    }

    private static Packable getResponse() {
        return SerializationUtil.readResponse();
    }
}
//        Socket socket = null;
//        DataOutputStream os = null;
//
//        String path = System.getProperty("user.dir") + "/src/client_" + (int) (Math.random() * 10000);
//        String responsePath = path + "_response";
//        Path p1 = Paths.get(path);
//        Path p2 = Paths.get(responsePath);
//
//        try {
//            Files.createFile(p1);
//            Files.createFile(p2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            socket = new Socket(HOST, PORT);
//            os = new DataOutputStream(socket.getOutputStream());
//            System.out.println(path);
//            os.writeBytes(path + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
