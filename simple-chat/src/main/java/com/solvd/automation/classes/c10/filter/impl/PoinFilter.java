package com.solvd.automation.classes.c10.filter.impl;

import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.impl.file.StreamTextFileReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class PoinFilter implements MessegeFilter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        PoinFilter n = new PoinFilter();
        String p = n.apply(answer);
        System.out.println(p);
    }

    public static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }


    public String apply(String message) {

        StringBuilder builder = new StringBuilder("");
        String s = firstUpperCase(message);
        String s1 = builder.append(s).append(".").toString();


        return s1;
    }
}
