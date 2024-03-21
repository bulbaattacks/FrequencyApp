package com.example.demo.service;

import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

class FrequencyServiceTest {
    String testWord;
    Map<Character, Integer> map;

    FrequencyService service = new FrequencyServiceImpl();


    @BeforeClass
    public void setup(){
        testWord = "aaaaabcccc";
        map = service.calculateSymbols(testWord);
    }

    @AfterClass
    public void tearDown(){
        testWord = null;
    }


    @Feature(value = "Класс FrequencyService")
    @Test(description = ("Тест проверяет частоту встречающегося символа"))
    void shouldCountFrequency() {
        Assert.assertEquals(map.size(), 3);
    }

    @Feature(value = "Класс FrequencyService")
    @Test(description = ("Тест проверяет, что символы идут по убыванию "))
    void shouldCheckOrder() {
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
