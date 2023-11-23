package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cidade")
@Getter
@Setter
public class Cidade {
    @Id
    @JsonIgnore
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="estado")
    private Estado estado;
    @JsonIgnore
    private int ibge;

    @OneToMany(mappedBy = "cidade")
    @JsonIgnore
    private List<Sindico> sindicos;
}
