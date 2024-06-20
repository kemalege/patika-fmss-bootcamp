package org.example.dto.request;

import java.math.BigDecimal;

public class InvoiceSaveRequest {
    private Long id;
    private BigDecimal totalAmount;

    public InvoiceSaveRequest(Long id, BigDecimal totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
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
}
