package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FrequencyServiceImpl implements FrequencyService {

    private final Map<Character, Integer> symbolFrequencyMap = new HashMap<>();

    @Override
    public LinkedHashMap<Character, Integer> calculateSymbols(String word) {
        char[] listOfSymbols = word.toCharArray();
        for (var ch : listOfSymbols) {
            symbolFrequencyMap.computeIfPresent(ch, (k, v) -> v + 1);
            symbolFrequencyMap.putIfAbsent(ch, 1);
        }
        var result = getMapSortedByValue(symbolFrequencyMap);
        symbolFrequencyMap.clear();
        return result;
    }

    private LinkedHashMap<Character, Integer> getMapSortedByValue(Map<Character, Integer> map){
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o1, o2) -> o1, LinkedHashMap::new));
    }
}

