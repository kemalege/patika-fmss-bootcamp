package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode; //-ordercode generate
    private Long customerId;
    private Long invoiceId;

    public Order(LocalDateTime createDate, List<Product> productList, String orderCode, Long customerId, Long invoiceId) {
        this.createDate = createDate;
        this.productList = productList;
        this.orderCode = orderCode;
        this.customerId = customerId;
        this.invoiceId = invoiceId;
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

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}

