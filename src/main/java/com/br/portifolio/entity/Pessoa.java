package com.br.portifolio.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "pessoa", schema = "public")
public class Pessoa extends AbstractEntity{

    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "datanascimento")
    private Date dataNascimento;

    @Getter @Setter
    @Column(name = "cpf")
    private String cpf;

    @Getter @Setter
    @Column(name = "funcionario")
    private Boolean funcionario;

}
