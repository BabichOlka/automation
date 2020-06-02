package com.solvd.automation.classes.c10;

import com.solvd.automation.constant.C10Constant;
import com.solvd.automation.util.PropertyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


public class Client {

    private static final Logger logger = LogManager.getLogger(Client.class);
    public static Set<String> chatHistory = new HashSet<>();
    final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
    final int PORT = Integer.parseInt(PropertyUtil.getValueByKey(C10Constant.PORT));
    final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String addr; // ip адрес клиента
    private int port; // порт соединения
    private String nickname; // имя клиента

    public Client(String HOST, int PORT) {
        this.addr = HOST;
        this.port = PORT;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            logger.error("Socket failed");
        }
        try {
            // потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNickname(); // перед началом необходимо спросит имя
            new ReadMsg().start(); // нить читающая сообщения из сокета в бесконечном цикле
            new WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой
            // ошибке, кроме ошибки конструктора сокета:
            Client.this.downService();
        }
        // В противном случае сокет будет закрыт
        // в методе run() нити.
    }

    private void pressNickname() {
        logger.info("Press your nick: ");
        try {
            nickname = inputUser.readLine();
            out.write("Hello " + nickname + "\n");
            out.flush();
        } catch (IOException ignored) {
        }

    }

    public void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine(); // ждем сообщения с сервера
                    if (str.equals("stop")) {
                        Client.this.downService();
                        break;
                    }
                    logger.info(str); // пишем сообщение с сервера на консоль
                }
            } catch (IOException e) {
                Client.this.downService();
            }
        }
    }

    // нить отправляющая сообщения приходящие с консоли на сервер
    public class WriteMsg extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine(); // сообщения с консоли
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        Client.this.downService();
                        break; // выходим из цикла если пришло "stop"
                    } else {
                        out.write(nickname + ": " + userWord + "\n"); // отправляем на сервер
                    }
                    out.flush(); // чистим
                } catch (IOException e) {
                    Client.this.downService(); // в случае исключения тоже харакири

                }

            }
        }
    }

    public static void main(String[] args) {
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.parseInt(PropertyUtil.getValueByKey(C10Constant.PORT));
        new Client(HOST, PORT);
    }

}
