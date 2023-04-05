package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="productos") //this is the table's name on DB, Java know the real reference of table using this way
public class Product {

    @Id //Because this column is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//'cause this key will generate automatically
    @Column(name="id_producto")//is the real column's name on DB
    private Integer idProduct;

    @Column(name="nombre")
    private String name;

    @Column(name="id_categoria")
    private Integer idCategory;

    @Column(name="codigo_barras")
    private String barCode;

    @Column(name="precio_venta")
    private Double price;

    @Column(name="cantidad_stock")
    private Integer stockNumber;

    @Column(name="estado")
    private boolean state;

}
