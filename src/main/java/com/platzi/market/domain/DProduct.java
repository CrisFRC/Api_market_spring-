package com.platzi.market.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DProduct {

    //Columns
    private int productId;
    private String nameD;
    private int categoryId;
    private BigDecimal priceD;
    private int stock;
    private boolean active;

    //relationship
    private DCategory categoryD;


}
