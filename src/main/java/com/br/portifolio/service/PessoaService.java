package com.br.portifolio.service;
import com.br.portifolio.entity.Pessoa;
import com.br.portifolio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findById(Long id){
        return this.pessoaRepository.findById(id).orElse(new Pessoa());
    }

    public Page<Pessoa> listAll(Pageable pageable){
        return this.pessoaRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Transactional
    public void insert(Pessoa pessoa){
        this.pessoaRepository.save(pessoa);
    }
    @Transactional
    public void update (Long id, Pessoa pessoa){
        if (id == pessoa.getId()){
            this.pessoaRepository.save(pessoa);
        }
        else{
            throw new RuntimeException();
        }
    }

    public Boolean isNomeNotNull(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

}
