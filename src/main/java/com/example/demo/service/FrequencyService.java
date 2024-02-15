package com.example.demo.service;

import java.util.LinkedHashMap;

public interface FrequencyService {

    LinkedHashMap<Character, Integer> calculateSymbols(String word);
}
