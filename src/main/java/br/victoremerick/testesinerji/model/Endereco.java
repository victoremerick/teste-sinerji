package br.victoremerick.testesinerji.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "endereco")
@ToString
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade;
    private String estado;
    private String logradouro;
    private Integer numero;
    private String cep;
    @JoinColumn(name = "pessoa_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa pessoa;
}
