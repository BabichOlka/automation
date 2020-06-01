package com.solvd.automation.classes.c10.filter;

import java.util.Set;
import java.util.stream.Collectors;

public interface MessegeFilter extends Filter {
      default String firstUpperCase(String word) {
          if (word == null || word.isEmpty()) return "";
          return word.substring(0, 1).toUpperCase() + word.substring(1);
     }
     default Set<String> getNewSet(Set<String> names) {
          return names.parallelStream().map(e -> e.toLowerCase()).collect(Collectors.toSet());
     }
     String apply(String message);
}
