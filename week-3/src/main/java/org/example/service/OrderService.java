package org.example.service;

import org.example.converter.InvoiceConverter;
import org.example.converter.OrderConverter;
import org.example.dto.request.InvoiceSaveRequest;
import org.example.dto.request.OrderSaveRequest;
import org.example.dto.response.OrderResponse;
import org.example.model.Invoice;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final InvoiceService invoiceService;
    private static final AtomicLong idCounter = new AtomicLong();

    public OrderService(OrderRepository orderRepository, ProductService productService, InvoiceService invoiceService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.invoiceService = invoiceService;
    }

    public void save(OrderSaveRequest request) {

        List<Product> productList = productService.getByIdList(request.getProductIdList());

        BigDecimal totalInvoiceAmount = sumProductAmounts(productList);

        InvoiceSaveRequest invoiceSaveRequest = new InvoiceSaveRequest(idCounter.incrementAndGet(), request.getCustomerId(), totalInvoiceAmount);

        Invoice invoice = InvoiceConverter.toInvoice(invoiceSaveRequest);
        invoiceService.save(invoiceSaveRequest);

        Order order = OrderConverter.toOrder(request, productList, invoice);

        orderRepository.save(order);

        System.out.println("order created" + order.toString());
    }

    public List<OrderResponse> getAll() {
        return OrderConverter.toResponse(orderRepository.getAll());
    }

    public BigDecimal sumProductAmounts(List<Product> productList) {
        return productList.stream()
                .map(Product::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
