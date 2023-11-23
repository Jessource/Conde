package com.fiap.conde.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contatos")
@Getter
@Setter
public class Contatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String linkedin;

    private String instagram;

    private String gmail;
    private String telefone;

    @OneToOne
    @JoinColumn(name="sindico_id")
    @JsonIgnore
    private Sindico sindico;
}
