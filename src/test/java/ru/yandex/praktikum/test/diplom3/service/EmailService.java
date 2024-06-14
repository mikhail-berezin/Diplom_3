package ru.yandex.praktikum.test.diplom3.service;

import static java.time.LocalTime.now;

public class EmailService {

    public static String generateEmail() {
        StringBuilder builder = new StringBuilder();
        builder.append("mbtest");
        builder.append(now().getHour());
        builder.append(now().getMinute());
        builder.append(now().getSecond());
        builder.append(now().getNano());
        builder.append("@foo.com");
        return builder.toString();
    }
}