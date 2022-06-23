package model;

import service.CustomerService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tester {


    public static void main(String[] args) {

        String date = "09/01/1983";
        System.out.println(date);
        Date objBday = new Date(date);
        System.out.println(objBday);

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String bday = format.format(objBday);
        System.out.println(bday);

    }



}
