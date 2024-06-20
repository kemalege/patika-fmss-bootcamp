package org.example.service;

import org.example.converter.InvoiceConverter;
import org.example.dto.request.InvoiceSaveRequest;
import org.example.dto.response.InvoiceResponse;
import org.example.model.Invoice;
import org.example.repository.InvoiceRepository;

import java.util.List;

public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void save(InvoiceSaveRequest request) {

        Invoice invoice = InvoiceConverter.toInvoice(request);

        invoiceRepository.save(invoice);

        System.out.println(invoice.toString());
    }

    public List<InvoiceResponse> getAll() {
        return InvoiceConverter.toResponse(invoiceRepository.getAll());
    }
}
