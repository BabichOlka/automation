package com.solvd.automation.classes.c10.filter.impl;

import com.solvd.automation.classes.c10.filter.MessegeFilter;
import com.vdurmont.emoji.EmojiParser;

import java.util.Set;

public class EmodgiFilter implements MessegeFilter {

    @Override
    public String apply(String message) {
       message = EmojiParser.parseToUnicode(message);
        return message;
    }
}
