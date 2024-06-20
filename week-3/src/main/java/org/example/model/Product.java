package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String name;
    private BigDecimal amount;
    private String description;

    public Product(String name, BigDecimal amount, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
