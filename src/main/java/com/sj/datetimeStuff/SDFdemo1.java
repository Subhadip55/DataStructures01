package com.sj.datetimeStuff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SDFdemo1 {
    public static void dateDifference(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);

//        calculate the date difference
        long date_diff = d2.getTime() - d1.getTime(); // in milliseconds

        long seconds = (date_diff/1000)%60;
        long minutes = (date_diff/(1000 * 60)) % 60;
        long hours = (date_diff/(1000 * 60 * 60)) % 24;
        long days = (date_diff/(1000 * 60 * 60 * 24)) % 365;
        long years = (date_diff/(1000L * 60 * 60 * 24 * 365));

        System.out.println("Years: "+years);
        System.out.println("Days: "+days);
        System.out.println("Hours: "+hours);
        System.out.println("Minutes: "+minutes);
        System.out.println("Seconds: "+seconds);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        try {
            dateDifference(date1, date2);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }
}
