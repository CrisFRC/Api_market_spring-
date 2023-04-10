package com.platzi.market.domain.repository;

import com.platzi.market.domain.DPurchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<DPurchase> getAll();
    Optional<List<DPurchase>> getByClient(String clientId);
    DPurchase save(DPurchase dPurchase);
}
