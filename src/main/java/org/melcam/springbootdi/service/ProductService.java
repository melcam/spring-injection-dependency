package org.melcam.springbootdi.service;

import org.melcam.springbootdi.model.Product;
import org.melcam.springbootdi.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            //calculamos un precio de impuesto a partir del precio multiplicado por impuesto
            Double priceImpuesto = p.getPrice() * 1.25d;
            p.setPrice(priceImpuesto.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
