package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        String message = "hello world";
        return message;
    }


    LocalTime nowLocalTime = LocalTime.now();
    LocalTime morning = LocalTime.of(8, 59);
    LocalTime noon = LocalTime.of(17, 59);
    LocalTime night = LocalTime.of(23, 59);
    LocalTime midnight = LocalTime.of(04, 00);


    @GetMapping("/greeting")
    public String greeting(@RequestParam String country) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String nowTime = now.format(timeFormat);

        LocalTime nowLocalTime = LocalTime.now();

        //04:00から08:59までは「おはようございます」を表示
        if (country.equals("japan") && nowLocalTime.isAfter(midnight) && nowLocalTime.isBefore(morning) || nowLocalTime.equals(morning) || nowLocalTime.equals(midnight)) {
            return nowTime + "   　　ゲストさん　　" + "おはようございます";
        }
        //09:00から17:59までは「こんにちわ」を表示
        else if (country.equals("japan") && nowLocalTime.isAfter(morning) && nowLocalTime.isBefore(noon) || nowLocalTime.equals(noon)) {
            return nowTime + "   　　ゲストさん　　" + "こんにちわ";
        }
        //18:00から03:59までは「こんばんわ」を表示
        else if (country.equals("japan") && nowLocalTime.isAfter(noon) && nowLocalTime.isBefore(night) || nowLocalTime.isBefore(midnight) || nowLocalTime.equals(night)) {
            return nowTime + "   　　ゲストさん　　" + "こんばんわ";
        }
        //04:00から08:59までは「Good morning」を表示
        else if (country.equals("usa") && nowLocalTime.isAfter(midnight) && nowLocalTime.isBefore(morning) || nowLocalTime.equals(morning) || nowLocalTime.equals(midnight)) {
            return nowTime + "   　　ゲストさん　　" + "Good morning";
        }
        //09:00から17:59までは「Good afternoon」を表示
        else if (country.equals("usa") && nowLocalTime.isAfter(morning) && nowLocalTime.isBefore(noon) || nowLocalTime.equals(noon)) {
            return nowTime + "   　　ゲストさん　　" + "Good afternoon";
        }
        //18:00から03:59までは「Good evening」を表示
        else if (country.equals("usa") && nowLocalTime.isAfter(noon) && nowLocalTime.isBefore(night) || nowLocalTime.isBefore(midnight) || nowLocalTime.equals(night)) {
            return nowTime + "   　　ゲストさん　　" + "Good evening";
        }
        return null;
    }


}


