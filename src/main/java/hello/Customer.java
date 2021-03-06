package hello;

import org.springframework.data.annotation.Id;

public class Customer {
    
    @Id
    private String id;
    
    private String firstName;
    private String lastName;
    
    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters for the Jackson ObjectMapper
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void updateCustomer(Customer customer) {
        this.lastName = customer.getLastName();
        this.firstName = customer.getFirstName();
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s'", id, firstName, lastName);
    }
}
