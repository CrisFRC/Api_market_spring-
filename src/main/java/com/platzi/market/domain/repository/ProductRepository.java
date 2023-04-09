package com.platzi.market.domain.repository;

import com.platzi.market.domain.DProduct;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    //Reglas de Dominio para acceder a un producto en la base de datos
    List<DProduct> getAll();
    List<DProduct> getByCategory(int categoryId);
    Optional<List<DProduct>> getScarceProduct(int quantity);
    Optional<DProduct> getProduct(int productId);
    DProduct save(DProduct product);
    void delete(int productId);



}
