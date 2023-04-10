package com.platzi.market.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DPurchaseItem {
    private int productId;
    private int quantityD;
    private BigDecimal totalD;
    private boolean active;
}
