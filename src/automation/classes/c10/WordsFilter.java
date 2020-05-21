package automation.classes.c10;

import automation.io.exception.UnableToReadException;
import automation.io.impl.file.StreamTextFileReader;

import java.util.*;
import java.util.stream.Collectors;

public class WordsFilter {
    public static void main(String[] args) throws UnableToReadException {
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        chesk(answer);
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

                Set<String> offences = Arrays.stream(
                        new StreamTextFileReader("src/words.txt")
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




