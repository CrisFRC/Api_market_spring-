package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="categorias")
public class Category {

    @Id //Because this column is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//'cause this key will generate automatically
    @Column(name="id_categoria")//is the real column's name on DB
    private Integer idCategory;

    @Column(name="descripcion")
    private String description;

    @Column(name="estado")
    private boolean state;

    //ADD RELATIONSHIPS BETWEEN TABLES
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
