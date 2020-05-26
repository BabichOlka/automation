package com.solvd.automation.classes.c10;

import com.solvd.automation.classes.c10.bo.ConnectMessage;
import com.solvd.automation.classes.c10.bo.ResponseMessage;
import com.solvd.automation.constant.C10Constant;
import com.solvd.automation.constant.TimeConstant;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.interfaces.Packable;
import com.solvd.automation.util.PropertyUtil;
import com.solvd.automation.util.SerializationUtil;
import com.vdurmont.emoji.EmojiParser;
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

    public static void main(String[] args) throws IOException, UnableToReadException, InterruptedException {
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.parseInt(PropertyUtil.getValueByKey(C10Constant.PORT));
        final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);


            connect( HOST, PORT, TOKEN);
           // logger.info(((ResponseMessage) getResponse()).getResp());

            Scanner in = new Scanner(System.in);

            while (true) {
                logger.info("Enter your message:");
                String answer = in.nextLine();

                if (StringUtils.trim(answer).equalsIgnoreCase("GoodBye")) {
                    logger.info("GoodBye");
                    break;
                } /*else if (answer.equalsIgnoreCase("refresh")){
                    Packable pkg = new ResponseMessage(HOST, PORT, "", "jhhhj", 200);
                    SerializationUtil.writeResponse(pkg);
                   // Packable obj = SerializationUtil.readResponse();
                  //  ResponseMessage msg = ((ResponseMessage) obj);
                   // String m = Server.chesk(msg.getResp());
                  //  logger.info(EmojiParser.parseToUnicode(m));
                };*/
                Packable pkg = new ConnectMessage(HOST, PORT, TOKEN, answer);
                SerializationUtil.writeObject(pkg);
                Thread.sleep(TimeConstant.TIME_TO_DELAY);
                logger.info(EmojiParser.parseToUnicode(((ResponseMessage) getResponse()).getResp()));
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
