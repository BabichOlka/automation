package com.solvd.automation.classes.c10.filter.impl;

import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.impl.file.StreamTextFileReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OffensesFilter implements MessegeFilter {

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

        return builder.toString();
    }

   @Override
    public String apply(String message) {
        try {
            message = chesk(message);
        } catch (UnableToReadException e) {
            e.printStackTrace();
        }
        return message;
    }
}
