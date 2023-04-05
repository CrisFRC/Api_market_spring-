package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
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


    //ADD RELATIONSHIPS BETWEEN TABLES
    @ManyToOne
    @JoinColumn(name= "id_compra", insertable = false,updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name="id_producto",insertable = false,updatable = false)
    private Product product;

}
