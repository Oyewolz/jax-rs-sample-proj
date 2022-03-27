package com.example.jax_rs_javaee.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author toyewole
 */
@Entity
@Getter
@Setter
public class Message extends AbstractEntity {

    @Column(name = "VALUE", nullable = false)
    private String value;
    @Column(name = "AUTHUR", nullable = false)
    private String author;

}
