package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Collectors;

@DisplayName("Класс FrequencyService должен")
@SpringBootTest
class FrequencyServiceTest {

    @Autowired
    private FrequencyService service;

    @DisplayName("посчитать частоту и проверить порядок по убыванию встречающегося символа")
    @Test
    void shouldCountFrequency() {
        String testWord = "aaaaabcccc";
        Map<Character, Integer> map = service.calculateSymbols(testWord);
        Assertions.assertThat(map).hasSize(3);
        var it = map.entrySet().iterator();
        var e1 = it.next();
        var e2 = it.next();
        var e3 = it.next();
        Assertions.assertThat(e1.getKey()).isEqualTo('a');
        Assertions.assertThat(e1.getValue()).isEqualTo(5);
        Assertions.assertThat(e2.getKey()).isEqualTo('c');
        Assertions.assertThat(e2.getValue()).isEqualTo(4);
        Assertions.assertThat(e3.getKey()).isEqualTo('b');
        Assertions.assertThat(e3.getValue()).isEqualTo(1);
    }
}
