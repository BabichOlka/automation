package com.solvd.automation.classes.c10;

import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.solvd.automation.classes.c10.filter.Story;
import com.solvd.automation.classes.c10.filter.impl.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.logging.Logger;

public class Server extends Thread {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getSimpleName());

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;

    public static LinkedList<Server> serverList = new LinkedList<>();
    public static Story story;

    private static Set<MessegeFilter> filters = new HashSet<>();

    static {

        filters.add(new NameFilter());
        filters.add(new CountryFilter());
        filters.add(new CapitalFilter());
        filters.add(new EmodgiFilter());
        filters.add(new OffensesFilter());
        filters.add(new PoinFilter());
    }

    private Socket socket; // сокет, через который сервер общается с клиентом,
    // кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет


    public Server(Socket socket) throws IOException {
        this.socket = socket;
        // если потоку ввода/вывода приведут к генерированию искдючения, оно проброситься дальше
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.story.printStory(out); // поток вывода передаётся для передачи истории последних 10
        // сооюбщений новому поключению
        start(); // вызываем run()
    }

    public Server() {

    }

    @Override
    public void run() {
        String word;
        try {
            // первое сообщение отправленное сюда - это никнейм
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush(); // flush() нужен для выталкивания оставшихся данных
                // если такие есть, и очистки потока для дьнейших нужд
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    word = filterMsg(in.readLine());
                    if (word.equals("stop")) {
                        this.downService(); // харакири
                        break; // если пришла пустая строка - выходим из цикла прослушки
                    }
                    LOGGER.info("Echoing: " + word);
                    Server.story.addStoryEl(word);
                    for (Server vr : Server.serverList) {
                        vr.send(word); // отослать принятое сообщение с привязанного клиента всем остальным влючая его
                    }
                }
            } catch (NullPointerException ignored) {
            }


        } catch (IOException e) {
            this.downService();
        }
    }

    /**
     * отсылка одного сообщения клиенту по указанному потоку
     *
     * @param msg
     */
    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {
        }

    }

    /**
     * закрытие сервера
     * прерывание себя как нити и удаление из списка нитей
     */
    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (Server vr : Server.serverList) {
                    if (vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
        LOGGER.info("Server Started");
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try {
                    serverList.add(new Server(socket)); // добавить новое соединенние в список
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }

    private static String filterMsg(String message) {
        for (MessegeFilter filter : filters) {
            message = filter.apply(message);
        }
        return message;
    }

    public LinkedList<Server> getServerList() {
        return serverList;
    }
}


