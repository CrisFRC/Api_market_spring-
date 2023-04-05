package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name="compras")
public class Purchase {

    @Id //Because this column is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//'cause this key will generate automatically
    @Column(name="id_compra")//is the real column's name on DB
    private Integer idPurchase;

    @Column(name="id_cliente")
    private String idClient;

    @Column(name="fecha")
    private LocalDateTime date;

    @Column(name="medio_pago")
    private String payType;

    @Column(name="comentario")
    private String comment;

    @Column(name="estado")
    private String state;
    
}
