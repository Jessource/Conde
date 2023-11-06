package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "avaliacao")
@Getter
@Setter
public class Avaliacao {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    private String comentario;

    private double classiicacao;

    @ManyToOne
    @JoinColumn(name="sindico_id")
    @JsonIgnore
    private Sindico sindico;
}
