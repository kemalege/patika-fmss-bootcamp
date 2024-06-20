package org.example.dto.response;

import java.math.BigDecimal;

public class InvoiceResponse {
    private Long id;
    private Long customerId;
    private BigDecimal totalAmount;

    public InvoiceResponse(Long id, Long customerId, BigDecimal totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
