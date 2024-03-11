package org.melcam.springbootdi.repository;

import org.melcam.springbootdi.model.Product;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "CPU Intel Core I9", 500L),
                new Product(3L, "Teclado Razer mini", 100L),
                new Product(4L, "Motherboard Gigabyte", 3801L)
        );
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
        // return data.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
