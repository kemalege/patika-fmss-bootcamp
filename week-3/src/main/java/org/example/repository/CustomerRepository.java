package org.example.repository;

import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Optional<Customer> findById(Long id) {
        return getCustomerList().stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    public Optional<Customer> findByEmail(String email) {
        return getCustomerList().stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }

}
