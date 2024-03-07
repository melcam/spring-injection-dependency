package org.melcam.springbootdi.repository;

import org.melcam.springbootdi.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product>findAll();
    Product findById(Long id);
}
