package org.example.repository;

import org.example.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private List<Invoice> invoiceList = new ArrayList<>();

    public void save(Invoice invoice) {
        invoiceList.add(invoice);
    }

    public List<Invoice> getAll() {
        return invoiceList;
    }
}
