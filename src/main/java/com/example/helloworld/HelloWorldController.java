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

    public final static LocalTime MORNING = LocalTime.of(8, 59);
    public final static LocalTime NOON = LocalTime.of(17, 59);
    public final static LocalTime NIGHT = LocalTime.of(23, 59);
    public final static LocalTime MIDNIGHT = LocalTime.of(04, 00);

    final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    @GetMapping("/greeting")
    public String greeting(@RequestParam String country) {

        LocalDateTime now = LocalDateTime.now();

        String nowTime = now.format(timeFormat);

        LocalTime nowLocalTime = now.toLocalTime();

        //04:00から08:59までは「おはようございます」を表示
        if (country.equals("japan") && nowLocalTime.isAfter(MIDNIGHT) && nowLocalTime.isBefore(MORNING) || nowLocalTime.equals(MORNING) || nowLocalTime.equals(MIDNIGHT)) {
            return nowTime + "   　　ゲストさん　　" + "おはようございます";
        }
        //09:00から17:59までは「こんにちわ」を表示
        else if (country.equals("japan") && nowLocalTime.isAfter(MORNING) && nowLocalTime.isBefore(NOON) || nowLocalTime.equals(NOON)) {
            return nowTime + "   　　ゲストさん　　" + "こんにちわ";
        }
        //18:00から03:59までは「こんばんわ」を表示
        else if (country.equals("japan") && nowLocalTime.isAfter(NOON) && nowLocalTime.isBefore(NIGHT) || nowLocalTime.isBefore(MIDNIGHT) || nowLocalTime.equals(NIGHT)) {
            return nowTime + "   　　ゲストさん　　" + "こんばんわ";
        }
        //04:00から08:59までは「Good morning」を表示
        else if (country.equals("usa") && nowLocalTime.isAfter(MIDNIGHT) && nowLocalTime.isBefore(MORNING) || nowLocalTime.equals(MORNING) || nowLocalTime.equals(MIDNIGHT)) {
            return nowTime + "   　　ゲストさん　　" + "Good morning";
        }
        //09:00から17:59までは「Good afternoon」を表示
        else if (country.equals("usa") && nowLocalTime.isAfter(MORNING) && nowLocalTime.isBefore(NOON) || nowLocalTime.equals(NOON)) {
            return nowTime + "   　　ゲストさん　　" + "Good afternoon";
        }
        //18:00から03:59までは「Good evening」を表示
        else if (country.equals("usa") && nowLocalTime.isAfter(NOON) && nowLocalTime.isBefore(NIGHT) || nowLocalTime.isBefore(MIDNIGHT) || nowLocalTime.equals(NIGHT)) {
            return nowTime + "   　　ゲストさん　　" + "Good evening";
        }
        return null;
    }

}