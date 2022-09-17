package com.br.portifolio.service;
import com.br.portifolio.entity.Membro;
import com.br.portifolio.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public Membro findById(Long id){
        return this.membroRepository.findById(id).orElse(new Membro());
    }

    public Page<Membro> listAll(Pageable pageable){
        return this.membroRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Transactional
    public void insert(Membro membro){
        this.membroRepository.save(membro);
    }
    @Transactional
    public void update (Long id, Membro membro){
        if (id == membro.getId()){
            this.membroRepository.save(membro);
        }
        else{
            throw new RuntimeException();
        }
    }

}
