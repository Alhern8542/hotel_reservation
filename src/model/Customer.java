package model;

public class Customer {

    String firstName;
    String lastName;
    String email;

    public Customer(String firstName, String lastName, String email) {
        //TODO: add regex to validate email; throw illegal Argument exception

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: "+firstName+" "+lastName+"\nEmail: "+email;
    }

}
