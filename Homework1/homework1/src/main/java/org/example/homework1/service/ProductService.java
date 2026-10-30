package org.example.homework1.service;

import lombok.RequiredArgsConstructor;
import org.example.homework1.entity.Product;
import org.example.homework1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(product.getName());
                    existing.setDescription(product.getDescription());
                    existing.setPrice(product.getPrice());
                    return productRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
