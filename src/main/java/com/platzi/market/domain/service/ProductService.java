package com.platzi.market.domain.service;


import com.platzi.market.domain.DProduct;
import com.platzi.market.domain.repository.DomainProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //diferenciación semántica
public class ProductService {
    @Autowired
    private DomainProductRepository domainProductRepository;

    public List<DProduct> getAll(){
        return domainProductRepository.getAll();
    }
    public Optional<DProduct> getProduct(int productId){
        return domainProductRepository.getProduct(productId);
    }
    public Optional<List<DProduct>> getByCategory(int categoryId){
        return domainProductRepository.getByCategory(categoryId);
    }
    public Optional<List<DProduct>> getScarceProduct(int quantity){
        return domainProductRepository.getScarceProduct(quantity);
    }
    public DProduct save(DProduct product){
        return domainProductRepository.save(product);
    }

    public boolean delete(int productId){
        try {
            if(domainProductRepository.getProduct(productId).isPresent()) {
                domainProductRepository.delete(productId);
                return true;
            }
            else{
                return false;
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }

    }

}
