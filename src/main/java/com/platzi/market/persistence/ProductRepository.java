package com.platzi.market.persistence;

import com.platzi.market.domain.DProduct;
import com.platzi.market.domain.repository.DomainProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // esta anotacion indica que esta es la clase que trabaja directamente con la base de datos
public class ProductRepository implements DomainProductRepository {
    @Autowired //anotación que permite a Spring inicializar e inyectar las dependencias
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<DProduct> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    public Optional<List<DProduct>> getByCategory(int idCategory) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<DProduct>> getScarceProduct(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockNumberLessThanAndState(quantity, true);
        return products.map(productsData -> mapper.toProducts(productsData));
    }

    @Override
    public Optional<DProduct> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public DProduct save(DProduct productDom) {
        Product productPer = mapper.toProductPer(productDom); //de una variable de dominio se traduce a una variable de persistencia
        return mapper.toProduct(productCrudRepository.save(productPer));
    }

    @Override
    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }


}
