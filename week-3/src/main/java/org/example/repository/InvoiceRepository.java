package org.example.repository;

import org.example.model.Customer;
import org.example.model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceRepository {
    private List<Invoice> invoiceList = new ArrayList<>();

    public void save(Invoice invoice) {
        invoiceList.add(invoice);
    }

    public List<Invoice> getAll() {
        return invoiceList;
    }

    public List<Invoice> findInvoicesByCustomerId(Long id) {
        return getAll().stream()
                .filter(invoice -> invoice.getCustomerId().equals(id))
                .collect(Collectors.toList());
    }
}
