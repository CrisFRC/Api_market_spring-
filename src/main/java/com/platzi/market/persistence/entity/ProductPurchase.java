package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="compras_productos")
public class ProductPurchase {

    @EmbeddedId //it's use when the primary key is composed
    private ProductPurchasePK id;

    @Column(name="cantidad")
    private Integer quantity;

    private BigDecimal total;

    @Column(name = "estado")
    private Boolean state;

}
