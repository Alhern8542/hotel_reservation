package model;

import java.util.regex.Pattern;

public class Customer {

    String firstName;
    String lastName;
    String email;

    public Customer(String firstName, String lastName, String email) {
        // email regex still works if "." is missing (ex .com)
        final String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(email).matches()) {
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("*Invalid email*");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name: "+firstName+" "+lastName+"  Email: "+email+"\n";
    }

}
