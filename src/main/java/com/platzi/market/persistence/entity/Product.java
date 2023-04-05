package com.platzi.market.persistence.entity;

import javax.persistence.*;

@Entity
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

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
