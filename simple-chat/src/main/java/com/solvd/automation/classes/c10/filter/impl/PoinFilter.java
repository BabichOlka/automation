package com.solvd.automation.classes.c10.filter.impl;

import com.solvd.automation.classes.c10.filter.MessegeFilter;

public class PoinFilter implements MessegeFilter {
    @Override
    public String apply(String message) {

        StringBuilder builder = new StringBuilder("");
        String s = firstUpperCase(message);
        String s1 = builder.append(s).append(".").toString();

        return s1;
    }
}
