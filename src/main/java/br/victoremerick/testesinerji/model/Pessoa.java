package br.victoremerick.testesinerji.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "pessoa")
@ToString
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date idade;
    private String sexo;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
    private List<Endereco> enderecos = new ArrayList<>();
}
