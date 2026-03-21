package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public void saveProduct(Product product){
        productRepository.saveProduct(product);
    }

    public List<Product> findProducts(){
        return productRepository.findProducts();
    }
}
