package com.example.demo.service;

import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

class FrequencyServiceTest {
    String testWord;
    Map<Character, Integer> map;

    FrequencyService service = new FrequencyServiceImpl();


    @BeforeMethod
    @Parameters({"word"})
    public void setup(String word){
        testWord = word;
        map = service.calculateSymbols(testWord);
    }

    @AfterMethod
    public void tearDown(){
        testWord = null;
    }

    @Attachment(type = "image/jpeg")
    public static byte[] sendBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

    @Step
    public void doSomething() {
        try {
            sendBytes("s.jpeg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Feature(value = "Класс FrequencyService")
    @Test(description = ("Тест проверяет частоту встречающегося символа"))
    void shouldCountFrequency() {
        doSomething();
        Assert.assertEquals(map.size(), 3);
    }

    @Feature(value = "Класс FrequencyService")
    @Test(description = ("Тест проверяет, что символы идут по убыванию "))
    void shouldCheckOrder() {
        doSomething();
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
