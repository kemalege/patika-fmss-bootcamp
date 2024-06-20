package org.example.dto.response;

import org.example.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {

    private String orderCode;
    private Long customerId;
    private LocalDateTime createDate;
    private List<Product> productList;
    private Long InvoiceId;

    public OrderResponse(String orderCode, List<Product> productList, LocalDateTime createDate, Long customerId, Long invoiceId) {
        this.orderCode = orderCode;
        this.productList = productList;
        this.createDate = createDate;
        this.customerId = customerId;
        this.InvoiceId = invoiceId;
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

    public Long getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        InvoiceId = invoiceId;
    }
}
