package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
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

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
