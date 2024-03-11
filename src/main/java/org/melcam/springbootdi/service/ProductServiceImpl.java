package org.melcam.springbootdi.service;

import org.melcam.springbootdi.model.Product;
import org.melcam.springbootdi.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryImpl repository;


    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            //calculamos un precio de impuesto a partir del precio multiplicado por impuesto
            Double priceImpuesto = p.getPrice() * 1.25d;
            //principio de inmutabilidad, para que no se incremente cada vez que se hace la peticion
            //Product newProduct=new Product(p.getId(),p.getName(),priceImpuesto.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceImpuesto.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
