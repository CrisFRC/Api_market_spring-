package com.platzi.market.persistence;

import com.platzi.market.domain.DPurchase;
import com.platzi.market.domain.repository.DomainPurchaseRepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.entity.Purchase;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository  implements DomainPurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<DPurchase> getAll() {
        return mapper.toPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<DPurchase>> getByClientId(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                    .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public DPurchase save(DPurchase dPurchase) {
        Purchase purchase = mapper.toPurchasePer(dPurchase);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));
        return mapper.toPurchase(purchaseCrudRepository.save(purchase));
    }
}
