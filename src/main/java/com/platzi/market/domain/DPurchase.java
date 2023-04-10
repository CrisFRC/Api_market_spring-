package com.platzi.market.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DPurchase {

    private int purchaseId;
    private String clientId;
    private LocalDateTime dateD;
    private String payMethod;
    private String commentD;
    private String stateD;
    private List<DPurchaseItem> item;


}
