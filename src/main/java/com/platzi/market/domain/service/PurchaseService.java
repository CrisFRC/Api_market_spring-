package com.platzi.market.domain.service;

import com.platzi.market.domain.DPurchase;
import com.platzi.market.domain.repository.DomainPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private DomainPurchaseRepository domainPurchaseRepository;
    public List<DPurchase> getAll() {
        return domainPurchaseRepository.getAll();
    }

    public Optional<List<DPurchase>> getByClientId(String clientId) {
        return domainPurchaseRepository.getByClientId(clientId);
    }

    public DPurchase save(DPurchase dPurchase) {
        return domainPurchaseRepository.save(dPurchase);
    }




}
