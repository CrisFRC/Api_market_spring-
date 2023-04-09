package com.platzi.market.web.controller;

import com.platzi.market.domain.DProduct;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<DProduct> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<DProduct> getProduct(int productId){
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<List<DProduct>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }
    @GetMapping("/product/scarce/{quantity}")
    public Optional<List<DProduct>> getScarceProduct(int quantity){
        return productService.getScarceProduct(quantity);
    }
    @PostMapping()
    public DProduct save(DProduct product){
        return productService.save(product);
    }
    @DeleteMapping("/{productId}")
    public boolean delete(int productId){
        try {
            productService.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
