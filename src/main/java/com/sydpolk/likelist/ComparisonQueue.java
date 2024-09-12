package com.sydpolk.likelist;

import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@Component
public class ComparisonQueue implements Comparator<String> {

    final TreeSet<String> pq = new TreeSet<>(this);
    final Map<Pair<String, String>, Integer> comparisons = new HashMap<>();

    @Override
    public int compare(final String str1, final String str2) {
        if (str1.equals(str2)) {
            return 0;
        }
        final Pair<String, String> pair = new Pair<>(str1, str2);
        if (comparisons.containsKey(pair)) {
            System.out.println("Found cached comparison for " + pair);
            return comparisons.get(pair);
        }
        System.out.println("Choose which item you like better.");
        System.out.println("1. " + str1);
        System.out.println("2. " + str2);
        String choice = "";
        while (!choice.equals("1") && !choice.equals("2")) {
            choice = LikeList.scanner.nextLine();
        }
        if (choice.equals("1")) {
            comparisons.put(pair, -1);
            return -1;
        } else if (choice.equals("2")) {
            comparisons.put(pair, 1);
            return 1;
        }
        return 0;
    }

    public void add(final String item) {
        pq.add(item);
    }

    public void output() {
        this.pq.forEach(item -> System.out.println(item));
    }
}

