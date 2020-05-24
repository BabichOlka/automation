package com.solvd.automation.classes.c10.bo;

import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.impl.file.StreamTextFileReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Scanner;


public class C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        chesk(answer);
    }

    public static String newWord(String answer) {
        StringBuilder sb = new StringBuilder(answer);
        sb.setCharAt(1, '*');
        String res = sb.toString();
        return res;
    }

    public static String chesk(String msg) {

        String[] splittedMsg = msg.split(" ");
        StringBuilder builder = new StringBuilder("");

        for (String word : splittedMsg) {
            try {

                Set<String> offences = Arrays.stream(
                        new StreamTextFileReader("src/words-all.txt")
                                .read()
                                .split("\r\n"))
                        .collect(Collectors.toSet());

                if (offences.contains(word.toLowerCase())) {

                    word = newWord(word);

                } else {

                    word = word;

                }
            } catch (UnableToReadException e) {
                e.printStackTrace();
            }
            builder.append(" ").append(word);
            ;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }


}


