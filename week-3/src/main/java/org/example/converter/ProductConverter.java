package org.example.converter;

import org.example.dto.request.ProductSaveRequest;
import org.example.dto.response.ProductResponse;
import org.example.model.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductConverter {

    public static Product toProduct(ProductSaveRequest request) {
        return new Product(
                request.getName(),
                request.getAmount(),
                request.getDescription()
        );
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getName(),
                product.getAmount(),
                product.getDescription()
        );
    }

    public static Set<ProductResponse> toResponse(Set<Product> products) {
        return products
                .stream()
                .map(ProductConverter::toResponse)
                .collect(Collectors.toSet());
    }
}
