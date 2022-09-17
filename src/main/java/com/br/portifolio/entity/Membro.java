package com.br.portifolio.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "membros", schema = "public")
public class Membro extends AbstractEntity{

    @Getter @Setter
    @JoinColumn(name = "idProjeto")
    @ManyToOne
    private Projeto projeto;

    @Getter @Setter
    @JoinColumn(name= "idPessoa")
    @OneToOne
    private Pessoa pessoa;
}
