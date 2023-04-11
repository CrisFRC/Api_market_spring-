package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DPurchaseItem;
import com.platzi.market.persistence.entity.ProductPurchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct",target = "productId"),
            @Mapping(source = "quantity",target = "quantityD"),
            @Mapping(source = "total",target = "totalD"),
            @Mapping(source = "state",target = "active")
    })
    DPurchaseItem toPurchaseItem(ProductPurchase productPurchase);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "purchase", ignore = true),
        @Mapping(target = "product", ignore = true),
        @Mapping(target = "id.idPurchase", ignore = true)
    })
    ProductPurchase toDPurchaseItem(DPurchaseItem item);


}
