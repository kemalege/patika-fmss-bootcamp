package org.example.dto.response;

import java.math.BigDecimal;

public class ProductResponse {

    private String name;
    private BigDecimal amount;
    private String description;

    public ProductResponse(String name, BigDecimal amount, String description) {
        this.name = name;
        this.amount = amount;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
