package com.br.portifolio.entity;
import com.br.portifolio.repository.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProjetoTest {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Test
    public void isdeletarProjeto() throws ParseException {
        Projeto projeto = new Projeto();

        String dataRecebida = "12/12/2022";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        projeto.setNome("teste");
        projeto.setDataInicio(formato.parse(dataRecebida));
        projeto.setDataFim(formato.parse(dataRecebida));
        projeto.setDataPrevisaoFim(formato.parse(dataRecebida));
        projeto.setDescricao("teste");
        projeto.setStatus(StatusProjetoEnum.em_analise);
        projetoRepository.save(projeto);

    }
}
