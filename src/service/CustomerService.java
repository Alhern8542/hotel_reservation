package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    static Map<String, Customer> customers = new HashMap<>();
    public void addCustomer(String email, String firstName, String lastName) {
        if (!customers.containsKey(email)) {
            Customer newCustomer = new Customer(firstName, lastName, email);
            customers.put(email, newCustomer);
        } else System.out.println("User with email:"+email+" already exists");
    }

    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers.values()) {
            customerList.add(customer);
        }
        return customerList;
    }

}
