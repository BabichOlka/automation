package com.solvd.lab.automation.v2.mybatis.formatter.util;

public class OperatorUtil {
    public static String normalizeMinus(String input) {

        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++) {

            if (inpupCharArray[i] == '-') {

                result.append(" - ");

            }
            else {
                result.append(inpupCharArray[i]);
            }
        }

        return String.valueOf(result);
    }

    public static String normalizePlus(String input) {
        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++) {

            if (inpupCharArray[i] == '+') {

                result.append(" + ");

            }
            else {
                result.append(inpupCharArray[i]);
            }
        }

        return String.valueOf(result);
    }

    public static String normalizeMultiply(String input) {
        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++) {

            if (inpupCharArray[i] == '*') {

                result.append(" * ");
            }
            else {
                result.append(inpupCharArray[i]);
            }
        }

        return String.valueOf(result);
    }

    public static String normalizeDivide(String input) {
        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++) {

            if (copiedCharArray[i] == '/') {

                result.append(" / ");

            }
            else {
                result.append(copiedCharArray[i]);
            }
        }

        return String.valueOf(result);
    }

    public static String normalizeEq(String input) {
        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++) {

            if (copiedCharArray[i] == '=' && (copiedCharArray[i - 1] != '=' || copiedCharArray[i + 1] != '=')) {

                result.append(" = ");

            }
            else {
                result.append(copiedCharArray[i]);
            }
        }

        return String.valueOf(result);
    }
}
