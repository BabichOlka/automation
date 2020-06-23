package com.solvd.lab.automation.v2.mybatis.formatter.util;

public class StatementUtil {

    public static String normalizeIfs(String input) {

        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++) {

            if (inpupCharArray[i] == 'i' && inpupCharArray[i + 1] == 'f'
                    && (inpupCharArray[i + 2] == ' ' || inpupCharArray[i + 2] == '(')) {

                result.append("if ");
            }
            else {
                result.append(inpupCharArray[i]);
            }
        }

        return String.valueOf(result);
    }



    public static String normalizeFors(String input) {
        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++) {

            if (inpupCharArray[i] == 'f' && inpupCharArray[i + 1] == 'o' && inpupCharArray[i + 2] == 'r'
                    && (inpupCharArray[i + 3] == ' ' || inpupCharArray[i + 3] == '(')) {

                result.append("for ");

            }
            else {
                result.append(inpupCharArray[i]);
            }
        }

        return String.valueOf(result);
    }

    public static String normalizeSemicolons(String input) {
        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++) {

            if (inpupCharArray[i] == ';') {

                if(inpupCharArray[i + 1] != '\n'){
                    result.append(";\n");
                } else {
                    result.append(";");
                }

            }
            else {
                result.append(inpupCharArray[i]);
            }
        }

        return String.valueOf(result);
    }
}
