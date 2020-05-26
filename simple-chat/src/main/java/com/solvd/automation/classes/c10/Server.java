package com.solvd.automation.classes.c10;

import com.solvd.automation.classes.c10.bo.ConnectMessage;
import com.solvd.automation.classes.c10.bo.ResponseMessage;
import com.solvd.automation.constant.TimeConstant;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.impl.file.StreamTextFileReader;
import com.solvd.automation.io.interfaces.Packable;
import com.solvd.automation.util.SerializationUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.util.*;
import java.util.logging.Logger;
import java.net.Socket;
import java.io.IOException;
import java.util.stream.Collectors;
import com.vdurmont.emoji.EmojiParser;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getSimpleName());
    public  static Set<String> chatHistory;
    private static final List<String> AVAILABLE_CLIENTS = Arrays.asList("user");
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;

    static Set<String> offences;

    static {
        try {
            offences = Arrays.stream(
                        new StreamTextFileReader(System.getProperty("user.dir") + "/src/main/resources/words-all.txt")
                                .read()
                                .split("\r\n"))
                        .collect(Collectors.toSet());
        } catch (UnableToReadException e) {
            e.printStackTrace();
        }
    }

    public Server() throws UnableToReadException {
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
    private static void listen() throws UnableToReadException {
        Packable obj = SerializationUtil.readObject();
        if (obj != null) {
            ConnectMessage msg = ((ConnectMessage) obj);
            if (msg.getHost().equals(HOST) && msg.getPort() == PORT && AVAILABLE_CLIENTS.contains(msg.getToken())) {
                String m = chesk(msg.getMessage());
                chatHistory.add(m);
                System.out.println(chatHistory);
                LOGGER.info(EmojiParser.parseToUnicode(m));
                Packable resp = new ResponseMessage(HOST, PORT, "", m, 200);
                sendResponse(resp);
            }
        }
    }

    private static void sendResponse(Packable pkg) {
        SerializationUtil.writeResponse(pkg);
    }

    public static String newWord(String answer) throws UnableToReadException {
        StringBuilder sb = new StringBuilder(answer);
        sb.setCharAt(1, '*');
        String res = sb.toString();
        return res;
    }

    public static String chesk(String msg) throws UnableToReadException {

        String[] splittedMsg = msg.split(" ");
        StringBuilder builder = new StringBuilder("");

        for (String word : splittedMsg) {
            try {

                if (offences.contains(word.toLowerCase())) {
                    word = newWord(word);
                } else {
                    word = word;
                }
            } catch (UnableToReadException e) {
                e.printStackTrace();
            }
            builder.append(" ").append(word);
        }
       // System.out.println(builder.toString());
        return builder.toString();
    }
}
    
//    private static final Logger LOGGER = Logger.getLogger(Server.class.getSimpleName());
//
//    private static final List<String> AVAILABLE_CLIENTS = new ArrayList<>();
//    private static final String HOST = "127.0.0.1";
//    private static final int PORT = 8000;
//
//    public static void main(String[] args) {
//        LOGGER.info(String.format("Listening on %s:%d", HOST, PORT));
//
//        ServerSocket serverSocket = null;
//        Socket socket = null;
//        BufferedReader is = null;
//
//        try {
//            serverSocket = new ServerSocket(PORT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        while (true) {
//            try {
//                assert serverSocket != null;
//                socket = serverSocket.accept();
//                LOGGER.info("Successfully connected to " + socket);
//                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//                AVAILABLE_CLIENTS.add(is.readLine());
//
//                for (String clientPath : AVAILABLE_CLIENTS) {
//                    listen(clientPath);
//                }
//                Thread.sleep(TimeConstant.TIME_TO_DELAY);
//            } catch (InterruptedException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // TODO: filter msgs
//    static void listen(String path) {
//        //SerializationUtil su = new SerializationUtil(path, path);
//        Packable obj = SerializationUtil.readObject();
//        if (obj != null) {
//            ConnectMessage msg = ((ConnectMessage) obj);
//            if (msg.getHost().equals(HOST) && msg.getPort() == PORT && AVAILABLE_CLIENTS.contains(msg.getToken())) {
//                LOGGER.info(msg.getMessage());
//                Packable resp = new ResponseMessage(HOST, PORT, "", "SUCCESS", 200);
//                sendResponse(resp);
//            }
//
//        }
//    }
//
//    private static void sendResponse(Packable pkg) {
//        SerializationUtil.writeResponse(pkg);
//    }
//}
//class Connection {
//    BufferedReader is;
//    Socket socket;
//    Server server;
//
//    public Connection(Socket socket, Server server) {
//        this.socket = socket;
//        this.server = server;
//
//        try {
//            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void run() throws IOException {
//        String input;
//
//        while (true) {
//            input = is.readLine();
//            if (input.equalsIgnoreCase("GoodBye")) {
//                is.close();
//                socket.close();
//                break;
//            }
//
//        }
//    }
//}