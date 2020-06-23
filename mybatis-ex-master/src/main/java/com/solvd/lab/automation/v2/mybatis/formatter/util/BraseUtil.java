package com.solvd.lab.automation.v2.mybatis.formatter.util;

public class BraseUtil {

    public static String normalizeSharpBraces(String input) {

        StringBuilder result = new StringBuilder();

        char[] inpupCharArray = input.toCharArray();
        for (int i = 0; i < inpupCharArray.length; i++){

            if (inpupCharArray[i] == '{'){

                 result.append(" {\n");
                }

             else if (inpupCharArray[i] == '}'){
                result.append("\n}");
            } else {
                result.append(inpupCharArray[i]);
            }

        }

        return String.valueOf(result);
    }
}
