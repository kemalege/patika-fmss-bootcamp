package org.example.dto.request;

import org.example.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderSaveRequest {

    private Long customerId;
    private List<Long> productIdList;

    public OrderSaveRequest(Long customerId, List<Long> productIdList) {
        this.customerId = customerId;
        this.productIdList = productIdList;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }
}
