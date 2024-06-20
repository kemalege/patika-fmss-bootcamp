package org.example.converter;

import org.example.dto.request.InvoiceSaveRequest;
import org.example.dto.response.InvoiceResponse;
import org.example.model.Invoice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InvoiceConverter {

    private static final AtomicLong idCounter = new AtomicLong();

    public static Invoice toInvoice(InvoiceSaveRequest request) {
        return new Invoice(
                request.getId(),
                request.getTotalAmount()
        );
    }

    public static InvoiceResponse toResponse(Invoice invoice) {
        return new InvoiceResponse(
                invoice.getId(),
                invoice.getTotalAmount()
        );
    }

    public static List<InvoiceResponse> toResponse(List<Invoice> invoices) {
        return invoices
                .stream()
                .map(InvoiceConverter::toResponse)
                .collect(Collectors.toList());
    }
}
