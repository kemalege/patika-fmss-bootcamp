package org.example.service;

import org.example.converter.InvoiceConverter;
import org.example.dto.request.InvoiceSaveRequest;
import org.example.dto.response.InvoiceResponse;
import org.example.exception.ApplicationException;
import org.example.exception.ExceptionMessages;
import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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

    public List<Invoice> getInvoicesByCustomerId(Long id) {
        return invoiceRepository.findInvoicesByCustomerId(id);
    }

    public List<Invoice> getInvoicesOverAmount(BigDecimal amount) {
        return invoiceRepository.getAll().stream()
                .filter(invoice -> invoice.getTotalAmount().compareTo(amount) > 0)
                .collect(Collectors.toList());
    }

    public OptionalDouble getAverageAmountOfInvoicesOver(BigDecimal amount) {
        return getAll().stream()
                .filter(invoice -> invoice.getTotalAmount().compareTo(amount) > 0)
                .mapToDouble(invoice -> invoice.getTotalAmount().doubleValue())
                .average();
    }

    public List<Invoice> getInvoicesUnderAmount(BigDecimal amount) {
        return invoiceRepository.getAll().stream()
                .filter(invoice -> invoice.getTotalAmount().compareTo(amount) < 0)
                .collect(Collectors.toList());
    }

    public List<InvoiceResponse> getAll() {
        return InvoiceConverter.toResponse(invoiceRepository.getAll());
    }
}
