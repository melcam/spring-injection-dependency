package org.melcam.springbootdi.service;

import org.melcam.springbootdi.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
