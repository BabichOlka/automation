package com.solvd.automation.classes.c10.filter.impl;

import com.solvd.automation.classes.c10.filter.MessegeFilter;

import java.util.Set;
 class OffensesFilter implements MessegeFilter {
   private static final Set<String> offences = null;
   // @Override
    public String apply(String message) {
        return message;
    }
}
