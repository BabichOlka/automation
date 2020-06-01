package com.solvd.automation.classes.c10;

import com.solvd.automation.classes.c10.bo.ConnectMessage;
import com.solvd.automation.classes.c10.bo.ResponseMessage;
import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.solvd.automation.classes.c10.filter.impl.*;
import com.solvd.automation.constant.TimeConstant;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.impl.file.StreamTextFileReader;
import com.solvd.automation.io.interfaces.Packable;
import com.solvd.automation.util.SerializationUtil;
import com.vdurmont.emoji.EmojiParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getSimpleName());
    public static Set<String> chatHistory = new HashSet<>();
    private static final List<String> AVAILABLE_CLIENTS = Arrays.asList("user");
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;


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
    public static void listen() throws UnableToReadException {
        NameFilter n = new NameFilter();
        MessegeFilter nameFilter = new NameFilter();
        MessegeFilter countryFilter = new CountryFilter();
        MessegeFilter capitalFilter = new CapitalFilter();
        MessegeFilter pointFilter = new PoinFilter();
        MessegeFilter offensesFilter = new OffensesFilter();
        MessegeFilter emojiFilter = new EmodgiFilter();
        Set<MessegeFilter> filters = new HashSet<>();
        filters.add(nameFilter);
        filters.add(capitalFilter);
        filters.add(countryFilter);
        filters.add(pointFilter);
        filters.add(offensesFilter);
        filters.add(emojiFilter);
        Packable obj = SerializationUtil.readObject();
        if (obj != null) {
            ConnectMessage msg = ((ConnectMessage) obj);
            if (msg.getHost().equals(HOST) && msg.getPort() == PORT && AVAILABLE_CLIENTS.contains(msg.getToken())) {
                String m = msg.getMessage();
                // chatHistory.add(m);
                //n.apply(m);
                System.out.println("name" + nameFilter.apply(msg.getMessage()));
                for (MessegeFilter filter : filters) {
                    m = filter.apply(m);
                }
                //System.out.println(chatHistory);
                LOGGER.info(m);
                Packable resp = new ResponseMessage(HOST, PORT, "", m, 200);
                sendResponse(resp);
            }
        }
    }

    private static void sendResponse(Packable pkg) {
        SerializationUtil.writeResponse(pkg);
    }
}


