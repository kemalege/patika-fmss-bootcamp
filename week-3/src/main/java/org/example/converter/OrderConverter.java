package org.example.converter;

import org.example.dto.request.OrderSaveRequest;
import org.example.dto.response.OrderResponse;
import org.example.model.Invoice;
import org.example.model.Order;
import org.example.model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class OrderConverter {

    private static final AtomicLong idCounter = new AtomicLong();

    public static Order toOrder(OrderSaveRequest request, List<Product> productList, Invoice invoice) {
        return new Order(
                LocalDateTime.now(),
                productList,
                UUID.randomUUID().toString(),
                request.getCustomerId(),
                invoice
        );
    }

    public static OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getOrderCode(),
                order.getProductList(),
                order.getCreateDate(),
                order.getCustomerId(),
                order.getInvoice().getId()
        );
    }

    public static List<OrderResponse> toResponse(List<Order> orders) {
        return orders
                .stream()
                .map(OrderConverter::toResponse)
                .collect(Collectors.toList());
    }
}
