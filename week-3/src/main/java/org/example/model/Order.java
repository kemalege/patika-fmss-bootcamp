package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode; //-ordercode generate
    private Long customerId;
    private Invoice invoice;

    public Order(LocalDateTime createDate, List<Product> productList, String orderCode, Long customerId, Invoice invoice) {
        this.createDate = createDate;
        this.productList = productList;
        this.orderCode = orderCode;
        this.customerId = customerId;
        this.invoice = invoice;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}

