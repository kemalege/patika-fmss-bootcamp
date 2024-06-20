package org.example.service;

import org.example.converter.CustomerConverter;
import org.example.dto.request.CustomerSaveRequest;
import org.example.exception.ApplicationException;
import org.example.exception.ExceptionMessages;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(CustomerSaveRequest request) {

        Optional<Customer> foundCustomer = customerRepository.findByEmail(request.getEmail());

        if (foundCustomer.isPresent()) {
            System.out.println(ExceptionMessages.EMAIL_ALREADY_EXIST);
            throw new ApplicationException(ExceptionMessages.EMAIL_ALREADY_EXIST);
        }

        Customer customer = CustomerConverter.toCustomer(request);

        customerRepository.createCustomer(customer);

        System.out.println("customer created." + customer.getEmail());
    }

    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }

    public Customer getById(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);

        if (foundCustomer.isEmpty()) {
            System.out.println(ExceptionMessages.CUSTOMER_NOT_FOUND);
            throw new ApplicationException(ExceptionMessages.CUSTOMER_NOT_FOUND);
        }

        return foundCustomer.get();
    }

    public List<Customer> getCustomersCreatedInJune() {
        return customerRepository.getCustomersCreatedInJune();
    }
}
