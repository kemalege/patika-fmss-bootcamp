package org.example.service;

import org.example.converter.ProductConverter;
import org.example.dto.request.ProductSaveRequest;
import org.example.dto.response.ProductResponse;
import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.util.List;
import java.util.Set;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductSaveRequest request) {

        Product product = ProductConverter.toProduct(request);

        productRepository.save(product);

        System.out.println(product.toString());
    }

    public Set<ProductResponse> getAll() {
        return ProductConverter.toResponse(productRepository.getAll());
    }

    public List<Product> getByIdList(List<Long> productIdList) {
        return productRepository.getAll().stream().toList();
    }
}
