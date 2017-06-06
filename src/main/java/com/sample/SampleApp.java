package com.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class SampleApp {

    public static void main(String[] args) {

        //SampleApp app = new SampleApp();
       // app.getTodaysDate();
    }


    public String printHello(){
        String str = "Hello World";
        System.out.println("printing "+str);
        return str;
    }


    public String getTodaysDate(){
        String date ;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        date = sdf.format(new Date());
        System.out.println("todays date is "+date.toString());
       return date;
    }
}
