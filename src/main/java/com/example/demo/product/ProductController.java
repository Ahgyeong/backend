package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    // 상품 조회, 상품 등록 담당
    @Autowired

    private ProductService productService;

    ProductController(){
        System.out.println("진짜 되나..? 진짜 스프링이 알아서 객체 생성을 하나..?");}
    //전체 상품 조회
    @GetMapping("/products")
    public List<Product> findProducts(){
        return productService.findProducts();
    }

    //개별 상품조회
    //@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable("id") int id){
        /**
         * 이 메소드 호출할 때 마다... 새로운 Service  객체가 생성되네..?
         * 이 메소드 밖에선... Service를 못 쓴다?
         */
//        ProductService productService = new ProductService();
        return productService.findProduct(id); }

    //@RequestMapping(value="/products", method = RequestMethod.POST)
    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }
}
