package org.example.model;

import java.math.BigDecimal;

public class Invoice {
    private Long id;
    private Long customerId;
    private BigDecimal totalAmount;

    public Invoice(Long id, Long customerId, BigDecimal totalAmount) {
        this.id = id;
        this.customerId = customerId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
