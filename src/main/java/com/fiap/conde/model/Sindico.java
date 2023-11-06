package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sindico")
@Getter
@Setter
public class Sindico {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String resumo;
    private double classificacao;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    @JsonIgnore
    private Cidade cidade;

}
