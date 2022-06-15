package model;

import service.CustomerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tester {

    public static void main(String[] args) {

       String strDate = "09/01/1983";
       Date dateObject = new Date(strDate);
       System.out.println(dateObject);

    }

}
