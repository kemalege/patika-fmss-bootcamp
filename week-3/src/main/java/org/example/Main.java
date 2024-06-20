package org.example;

import org.example.dto.request.CustomerSaveRequest;
import org.example.dto.request.OrderSaveRequest;
import org.example.dto.request.ProductSaveRequest;
import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.repository.CustomerRepository;
import org.example.repository.InvoiceRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;
import org.example.service.OrderService;
import org.example.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        ProductRepository productRepository = new ProductRepository();

        ProductService productService = new ProductService(productRepository);
        InvoiceService invoiceService = new InvoiceService(invoiceRepository);
        OrderService orderService = new OrderService(orderRepository, productService, invoiceService);
        CustomerService customerService = new CustomerService(customerRepository);

        CustomerSaveRequest customer1 = new CustomerSaveRequest("can", "demir", "can@gmail.com", "123456");
        CustomerSaveRequest customer2 = new CustomerSaveRequest("kemal", "ege", "ege@gmail.com", "123456");

        ProductSaveRequest product1 = new ProductSaveRequest("SmartPhone", new BigDecimal(1500), "Mobile device");
        ProductSaveRequest product2 = new ProductSaveRequest("Book", new BigDecimal(30), "Novel");
        ProductSaveRequest product3 = new ProductSaveRequest("Watch", new BigDecimal(500), "Smart watch");

        customerService.save(customer1);
        customerService.save(customer2);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        List<Long> productIds = new ArrayList<>();
        productIds.add(1L);
        productIds.add(2L);
        productIds.add(3L);

        OrderSaveRequest order1 = new OrderSaveRequest(1L, productIds);
        OrderSaveRequest order2 = new OrderSaveRequest(2L, productIds);

        orderService.save(order1);
        orderService.save(order2);

        List<Customer> customers = customerService.getCustomerList();
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("\nCustomers with 'C' in their name:");
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains("c") || customer.getSurname().toLowerCase().contains("c")) {
                System.out.println(customer);
            }
        }

        System.out.println("\nTotal amount of invoices for customers created in June:");
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<Customer> customersCreatedInJune = customerService.getCustomersCreatedInJune();
        for (Customer customer : customersCreatedInJune) {
            List<Invoice> invoices = invoiceService.getInvoicesByCustomerId(customer.getId());
            for (Invoice invoice : invoices) {
                totalAmount = totalAmount.add(invoice.getTotalAmount());
            }
        }
        System.out.println("Total Amount: " + totalAmount);

        System.out.println("\nAll invoices:");
        List<Invoice> allInvoices = invoiceRepository.getAll();
        for (Invoice invoice : allInvoices) {
            System.out.println(invoice);
        }

        System.out.println("\nInvoices over 1500:");
        List<Invoice> invoicesOver1500 = invoiceService.getInvoicesOverAmount(new BigDecimal(1500));
        for (Invoice invoice : invoicesOver1500) {
            System.out.println(invoice);
        }

        System.out.println("\nAverage amount of invoices over 1500:");
        OptionalDouble averageAmount = invoiceService.getAverageAmountOfInvoicesOver(new BigDecimal(1500));
        if (averageAmount.isPresent()) {
            System.out.println("Average Amount: " + averageAmount.getAsDouble());
        } else {
            System.out.println("No invoices over 1500 TL found.");
        }

        System.out.println("\nCustomers with invoices under 500:");
        List<Invoice> invoicesUnder500 = invoiceService.getInvoicesUnderAmount(new BigDecimal(500));
        List<Long> customerIdsWithInvoicesUnder500 = invoicesUnder500.stream()
                .map(Invoice::getCustomerId)
                .distinct()
                .toList();

        for (Customer customer : customers) {
            if (customerIdsWithInvoicesUnder500.contains(customer.getId())) {
                System.out.println(customer.getName() + " " + customer.getSurname());
            }
        }

    }

}