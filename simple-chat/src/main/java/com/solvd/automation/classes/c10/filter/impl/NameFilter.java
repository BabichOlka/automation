package com.solvd.automation.classes.c10.filter.impl;

import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.impl.file.StreamTextFileReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class NameFilter implements MessegeFilter {


    public static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    private static Set<String> names;

    static {
        try {
            names = Arrays.stream(
                    new StreamTextFileReader(System.getProperty("user.dir") + "/src/main/resources/name.txt")
                            .read()
                            .split("\r\n"))
                    .collect(Collectors.toSet());
        } catch (UnableToReadException e) {
            e.printStackTrace();
        }
    }
    public static Set<String> getNewSet(Set<String> names){
        Set<String> newNames = new HashSet<>();

        for (String s:names) {
            for (String a: s.split(" ")){
             newNames.add( a.toLowerCase());
            }
        } return newNames;
    }
     //@Override
    public  String apply(String message) {
        String[] splittedMsg = message.split(" ");
        StringBuilder builder = new StringBuilder("");

            for (String word : splittedMsg) {


                if (getNewSet(names).contains(word.toLowerCase())) {
                    word = firstUpperCase(word);

                } else {
                    word = word;
                }builder.append(" ").append(word);
                }

        return builder.toString();
        }
}

