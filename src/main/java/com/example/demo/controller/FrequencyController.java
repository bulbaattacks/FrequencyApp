package com.example.demo.controller;

import com.example.demo.service.FrequencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FrequencyController {

    private final FrequencyService service;

    @GetMapping("/frequency")
    public Map<Character, Integer> getFrequency(@RequestParam String word) {
        validateRequest(word);
        return service.calculateSymbols(word);
    }

    private void validateRequest(String param) {
        if (!param.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Only alphabets allowed");
        }
    }
}
