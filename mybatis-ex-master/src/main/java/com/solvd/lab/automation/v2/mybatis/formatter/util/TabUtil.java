package com.solvd.lab.automation.v2.mybatis.formatter.util;

public class TabUtil {

    private static String makeTab(int tabCount) {
        String tabs = "";
        for (int i = 0; i < tabCount; i++){
            tabs += "\t";
        }
        return tabs;
    }
    public static String normalizeTabs(String input){
        int length = input.length();

        String result = "";
        int tabCount = 0;
        String tabs = "";

        char ch;

        for (int i = 0; i < length; i++) {
            ch = input.charAt(i);
            result += ch;
            if (ch == '{'){
                tabs = makeTab(++tabCount);
            } else if (ch == '\n') {
                result += tabs;
            } else if (ch == '}') {
                tabs = makeTab(--tabCount);
            }
        }

        return result;
    }
}
//}

//    public static String normalizeTabs(String input) {
//        String[] inpupCharArray = input.split("\n");
//
//        for (int i = inpupCharArray.length - 1; i > 0; i--){
//
//            if(inpupCharArray[i].contains("}")){
//                int leftBracketsCounter = 0;
//                int rightBracketsCounter = 1;
//                int j = i - 1;
//
//                while (leftBracketsCounter != rightBracketsCounter){
//
//                    inpupCharArray[j] = "\t" + inpupCharArray[j];
//
//                    if (inpupCharArray[j].contains("{")){
//                        leftBracketsCounter++;
//                    }
//
//                    if (inpupCharArray[j].contains("}")){
//                        rightBracketsCounter++;
//                    }
//                    j--;
//                }
//            }
//        }
//
//        for (int i = 0; i < inpupCharArray.length; i++){
//            if(inpupCharArray[i].contains("{")){
//                inpupCharArray[i] = inpupCharArray[i].replaceFirst("\t", "");
//            }
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (String element : inpupCharArray){
//            result.append(element);
//            result.append("\n");
//        }
//
//        return String.valueOf(result);
//    }
//}
