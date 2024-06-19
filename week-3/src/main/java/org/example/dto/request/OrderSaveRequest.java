package org.example.dto.request;

import org.example.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderSaveRequest {

    private LocalDateTime createDate;
    private Long customerId;
    private List<Product> productList;

}
