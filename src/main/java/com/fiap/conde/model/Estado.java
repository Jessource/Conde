package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "estado")
@Getter
@Setter
public class Estado {
    @Id
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private String nome;
    private String uf;
    @JsonIgnore
    private int ibge;
    @JsonIgnore
    private String ddd;
    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Cidade> cidades;
}
