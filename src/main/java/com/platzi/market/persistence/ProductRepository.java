package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // esta anotacion indica que esta es la clase que trabaja directamente con la base de datos
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory){
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }
    public Optional<List<Product>> getNonStock(int stockNumber, boolean state){
        return productCrudRepository.findByStockNumberLessThanAndState(stockNumber,state);
    }
    public Optional<Product>  getById(int idProduct){ //dado por los repositorios de spring data
        return productCrudRepository.findById(idProduct);
    }

    public Product save(Product product){ //dado por los repositorios de spring data
        return  productCrudRepository.save(product);
    }

    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }


}
