package org.example.converter;

import org.example.dto.request.CustomerSaveRequest;
import org.example.model.Customer;
import org.example.util.HashUtil;

import java.util.concurrent.atomic.AtomicLong;

public class CustomerConverter {

    private static final AtomicLong idCounter = new AtomicLong();

    public static Customer toCustomer(CustomerSaveRequest request) {
        String hashedPassword = HashUtil.generate(request.getPassword());

        Customer customer = new Customer(request.getName(), request.getSurname(), request.getEmail(), hashedPassword);
        customer.setId(idCounter.incrementAndGet());
        return customer;
    }
}
