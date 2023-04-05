package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="clientes")
public class Client {

    @Id
    private String id;

    @Column(name="nombre")
    private String name;

    @Column(name="apellidos")
    private String lastName;

    @Column(name="celular")
    private Long phone;

    @Column(name="direccion")
    private String address;

    @Column(name="correo_electronico")
    private String email;

}
