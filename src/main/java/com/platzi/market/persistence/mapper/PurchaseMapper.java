package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DPurchase;
import com.platzi.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "date", target = "dateD"),
            @Mapping(source = "payType", target = "payMethod"),
            @Mapping(source = "comment", target = "commentD"),
            @Mapping(source = "state", target = "stateD"),
            @Mapping(source = "products", target = "items")
    })
    DPurchase toPurchase(Purchase purchase);
    List<DPurchase> toPurchases(List<Purchase> purchaseList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "client", ignore = true)
    })
    Purchase toPurchasePer(DPurchase purchase);


}
