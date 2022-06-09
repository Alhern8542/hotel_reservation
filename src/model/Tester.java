package model;

import service.CustomerService;

public class Tester {

    public static void main(String[] args) {


//        Customer testing = new Customer("Alberto", "Hernandez", "alhern@gmail.com");
//        System.out.println(testing);

        CustomerService.addCustomer("alhern8542@gmail.com","Alberto","Hernandez");
        CustomerService.addCustomer("babycutie9@gmail.com","Keyhra","Hernandez");
        CustomerService.addCustomer("bigkid10@gmail.com","Noemi","Santos");

        System.out.println(CustomerService.getCustomer("babycutie9@gmail.com"));

        System.out.println(CustomerService.getAllCustomers());
    }

}
