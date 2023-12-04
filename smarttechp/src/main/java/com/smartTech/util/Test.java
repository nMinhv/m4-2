package com.smartTech.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println("email123@example.com".matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"));
        System.out.println("a@example.com".matches("^[A-Za-z0-9+_.-]+@(.+)$"));

        Date date = new Date();
        long t = date.getTime() + 86400000;
        Date date1  = new Date(t);
        System.out.println(date1);
        System.out.println(date);

    }
}
