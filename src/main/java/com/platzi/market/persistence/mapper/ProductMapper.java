package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DProduct;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) //se añade por que category ya tiene mapper
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "nameD"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "price", target = "priceD"),
            @Mapping(source = "stockNumber", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "categoryD") //objeto category que ya tiene mapper

    })
    DProduct toProduct(Product product);
    List<DProduct> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProductPer(DProduct product);

}

