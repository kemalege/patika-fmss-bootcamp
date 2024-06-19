package org.example.converter;

import com.patika.kitapyurdum.dto.request.OrderSaveRequest;
import com.patika.kitapyurdum.dto.response.OrderResponse;
import com.patika.kitapyurdum.model.Order;
import com.patika.kitapyurdum.model.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConverter {

    public static Order toOrder(OrderSaveRequest request) {
        return Order.builder()
                .orderCode(UUID.randomUUID().toString())
                .createDate(request.getCreateDate())
                .orderStatus(OrderStatus.INITIAL)
                .productList(request.getProductList())
                .customerId(request.getCustomerId())
                .build();
    }

    public static OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .orderCode(order.getOrderCode())
                .productList(order.getProductList())
                .createDate(order.getCreateDate())
                .orderStatus(order.getOrderStatus())
                .customerId(order.getCustomerId())
                .build();
    }

    public static List<OrderResponse> toResponse(List<Order> orders) {
        return orders
                .stream()
                .map(OrderConverter::toResponse)
                .collect(Collectors.toList());
    }
}
