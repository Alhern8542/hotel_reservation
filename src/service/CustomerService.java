package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    static Map<String, Customer> customers = new HashMap<>();
    public static void addCustomer(String email, String firstName, String lastName) {
        Customer newCustomer = new Customer(firstName, lastName, email);
        customers.put(email, newCustomer);
    }

    public static Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers.values()) {
            customerList.add(customer);
        }
        return customerList;
    }




}