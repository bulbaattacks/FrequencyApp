package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.util.Map;

@Description("Класс FrequencyService должен")
class FrequencyServiceTest {
    String testWord;

    FrequencyService service = new FrequencyServiceImpl();


    @BeforeClass
    public void setup(){
        testWord = "aaaaabcccc";
    }

    @AfterClass
    public void tearDown(){
        testWord = null;
    }


    @Test(description = ("посчитать частоту и проверить порядок по убыванию встречающегося символа"))
    void shouldCountFrequency() {
        Map<Character, Integer> map = service.calculateSymbols(testWord);
//        assert(map.size(), int i = 3);
        var it = map.entrySet().iterator();
        var e1 = it.next();
        var e2 = it.next();
        var e3 = it.next();
        assert(e1.getKey()).equals('a');
        assert (e1.getValue()).equals(5);
        assert (e2.getKey()).equals('c');
        assert (e2.getValue()).equals(4);
        assert (e3.getKey()).equals('b');
        assert (e3.getValue()).equals(1);
    }
}
