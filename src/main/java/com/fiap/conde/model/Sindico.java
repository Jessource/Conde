package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String resumo;
    private double classificacao;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @OneToMany(mappedBy = "sindico")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProcessoJuridico> processo;

    @OneToMany(mappedBy = "sindico")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<HistoricoProfissional> profissional;

    @OneToMany(mappedBy = "sindico")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<HistoricoEducacao> educacao;

    @OneToOne(mappedBy = "sindico")
    private Contatos contatos;

    @OneToMany(mappedBy = "sindico")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Avaliacao> avaliacao;

}
