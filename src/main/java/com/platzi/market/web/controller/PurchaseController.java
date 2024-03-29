package com.platzi.market.web.controller;

import com.platzi.market.domain.DPurchase;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<DPurchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<List<DPurchase>> getByClient(@PathVariable("clientId") String clientId) {
        return purchaseService.getByClientId(clientId)
                .filter(dPurchases -> !dPurchases.isEmpty()) //filtrar los resultados y preguntar si no está vacio
                .map(dPurchases -> new ResponseEntity<>(dPurchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<DPurchase> save(@RequestBody DPurchase dPurchase) {
        return new ResponseEntity<>(purchaseService.save(dPurchase),HttpStatus.CREATED);
    }


}
