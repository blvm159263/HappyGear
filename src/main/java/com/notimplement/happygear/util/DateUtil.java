package com.notimplement.happygear.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    public static String getCurrentDateTime(){
        return now.format(formatter);
    }
}
