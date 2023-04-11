package com.platzi.market.domain.repository;

import com.platzi.market.domain.DPurchase;

import java.util.List;
import java.util.Optional;

public interface DomainPurchaseRepository {

    List<DPurchase> getAll();
    Optional<List<DPurchase>> getByClientId(String clientId);
    DPurchase save(DPurchase dPurchase);
}
