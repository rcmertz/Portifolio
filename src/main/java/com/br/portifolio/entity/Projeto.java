package com.br.portifolio.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "projeto", schema = "public")
public class Projeto extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "data_inicio")
    private Date dataInicio;

    @Getter @Setter
    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @Getter @Setter
    @Column(name = "data_fim")
    private Date dataFim;

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @Column(name = "status")
    private StatusProjetoEnum status;

    @Getter @Setter
    @Column(name = "orcamento")
    private Float orcamento;

    @Getter @Setter
    @Column(name = "risco")
    private ClassificacaoProjetoEnum risco;

    @Getter @Setter
    @Column(name = "id_gerente")
    private Boolean idGerente;

}
