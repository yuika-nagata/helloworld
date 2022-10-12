package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
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


    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter Time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String nowTime = now.format(Time);


    public static final LocalTime nowLocalTime = LocalTime.now();
    public static final LocalTime morning = LocalTime.of(8, 59);
    public static final LocalTime noon = LocalTime.of(17, 59);
    public static final LocalTime night = LocalTime.of(23, 59);
    public static final LocalTime midnight = LocalTime.of(04, 00);


    @GetMapping("/japan")
    public String greeting() {
        //04:00から08:59までは「おはようございます」を表示
        if (nowLocalTime.isAfter(midnight) && nowLocalTime.isBefore(morning) || nowLocalTime.equals(morning) || nowLocalTime.equals(midnight)) {
            return nowTime + "   　　ゲストさん　　" + "おはようございます";
        }
        //09:00から17:59までは「こんにちわ」を表示
        else if (nowLocalTime.isAfter(morning) && nowLocalTime.isBefore(noon) || nowLocalTime.equals(noon)) {
            return nowTime + "   　　ゲストさん　　" + "こんにちわ";
        }
        //18:00から03:59までは「こんばんわ」を表示
        else if (nowLocalTime.isAfter(noon) && nowLocalTime.isBefore(night) || nowLocalTime.isBefore(midnight) || nowLocalTime.equals(night)) {
            return nowTime + "   　　ゲストさん　　" + "こんばんわ";
        }
        return null;
    }

    @GetMapping("/usa")
    public String usaGreeting() {
        //04:00から08:59までは「おはようございます」を表示
        if (nowLocalTime.isAfter(midnight) && nowLocalTime.isBefore(morning) || nowLocalTime.equals(morning) || nowLocalTime.equals(midnight)) {
            return nowTime + "   　　ゲストさん　　" + "Good morning";
        }
        //09:00から17:59までは「こんにちわ」を表示
        else if (nowLocalTime.isAfter(morning) && nowLocalTime.isBefore(noon) || nowLocalTime.equals(noon)) {
            return nowTime + "   　　ゲストさん　　" + "Good afternoon";
        }
        //18:00から03:59までは「こんばんわ」を表示
        else if (nowLocalTime.isAfter(noon) && nowLocalTime.isBefore(night) || nowLocalTime.isBefore(midnight) || nowLocalTime.equals(night)) {
            return nowTime + "   　　ゲストさん　　" + "Good evening";
        }
        return null;
    }
}

