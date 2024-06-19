package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode; //-ordercode generate
    private Long customerId;

}

