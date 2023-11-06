package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private Cidade cidade;

    @OneToMany(mappedBy = "sindico")
    @JsonIgnore
    private List<ProcessoJuridico> processo;

    @OneToMany(mappedBy = "sindico")
    @JsonIgnore
    private List<HistoricoProfissional> profissional;

    @OneToMany(mappedBy = "sindico")
    @JsonIgnore
    private List<HistoricoEducacao> educacao;

    @OneToOne(mappedBy = "sindico")
    @JsonIgnore
    private Contatos contatos;

    @OneToOne(mappedBy = "sindico")
    @JsonIgnore
    private  Avaliacao avaliacao;

}
