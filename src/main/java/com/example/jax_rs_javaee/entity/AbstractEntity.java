package com.example.jax_rs_javaee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author toyewole
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -1355486069083824369L;
    @Id
    @GeneratedValue
    @Column(name= "pk",
            nullable = false,
            insertable = true,
            updatable = false)
    private Long id;


    @Column(name = "CREATE_DATE" , nullable = false , updatable = false )
    private LocalDate createDate = LocalDate.now();

    @Column(name = "LAST_MODIFIED", nullable = false)
    private LocalDate lastModified ;

    @Column(name= "DELETE")
    private boolean deleted;

    @Column(name= "ACTIVE")
    private boolean active;


}
