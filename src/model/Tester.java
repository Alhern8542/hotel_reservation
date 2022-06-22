package model;

import service.CustomerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tester {


    public static void main(String[] args) {

       Calendar cal = Calendar.getInstance();
       cal.setTime(new Date("09/01/1983"));
       cal.add(Calendar.DATE, 7);
       Date afterBDay = cal.getTime();

       System.out.println(afterBDay);

    }



}
