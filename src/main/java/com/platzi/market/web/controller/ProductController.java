package com.platzi.market.web.controller;


import com.platzi.market.domain.DProduct;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<DProduct>> getAll(){
        return new ResponseEntity<>( productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DProduct> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(dProduct -> new ResponseEntity<>(dProduct,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DProduct>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .filter(dProducts -> !dProducts.isEmpty())
                .map(dProducts -> new ResponseEntity<>(dProducts,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/scarce/{quantity}")
    public ResponseEntity<List<DProduct>> getScarceProduct(@PathVariable("quantity") int quantity){
        return productService.getScarceProduct(quantity)
                .filter(dProducts -> !dProducts.isEmpty())
                .map(dProducts -> new ResponseEntity<>(dProducts,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<DProduct> save(@RequestBody  DProduct product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable("productId") int productId){
        return productService.delete(productId)?
                new ResponseEntity(HttpStatus.OK):
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
