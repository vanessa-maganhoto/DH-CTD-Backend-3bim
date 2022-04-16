package br.com.dh.ctd.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "categories")
public class Categories implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // Aqui colocaremos timestamps automático
    @Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
    private Instant criado;
    @Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
    private Instant atualizado;

    @PrePersist
    public void antesDeSalvar(){
        criado = Instant.now();
    }

    @PreUpdate
    public void antesDeAtualizar(){
        atualizado = Instant.now();
    }
    public Categories() {
    }

    public Categories(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categories(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCriado() {
        return criado;
    }

    public Instant getAtualizado() {
        return atualizado;
    }

}
